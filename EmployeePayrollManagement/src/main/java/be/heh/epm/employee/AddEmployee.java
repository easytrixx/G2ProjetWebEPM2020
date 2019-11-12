package be.heh.epm.employee;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.method.DirectDepositMethod;
import be.heh.epm.schedule.PaymentSchedule;

public abstract class AddEmployee implements Command {
    int id;
    String name;
    String adresse;
    protected Employee employee;

    public AddEmployee(int id, String name, String adresse){
       this.id=id;
       this.name=name;
       this.adresse=adresse;
       employee=new Employee(id, name, adresse);
    }

    @Override
    public void execute() {
        employee.setPayClassification(makePaymentClassification());
        Context.emp.save(employee.getId(), employee);
        employee.setPayMethod(new DirectDepositMethod("Fortis","be332211"));
        employee.setPaySchedule(makePaymentSchedule());
    }
    public abstract PaymentClassification makePaymentClassification();
    public abstract PaymentSchedule makePaymentSchedule();
}
