package be.heh.epm.commission;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.employee.AddEmployee;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.PaymentSchedule;

public class AddCommisionnedEmployee extends AddEmployee {
    double salary;
    double commission;

    public AddCommisionnedEmployee(int empID, String name, String adresse, double salary, double commission) {
        super(empID, name, adresse);
        this.salary = salary;
        this.commission = commission;
    }

    @Override
    public PaymentClassification makePaymentClassification() {
        return new CommisionnedClassification(salary, commission);
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new MonthlyPaymentSchedule();
    }
}
