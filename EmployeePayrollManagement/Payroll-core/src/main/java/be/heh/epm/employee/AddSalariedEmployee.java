package be.heh.epm.employee;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.classification.SalariedClassification;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployee {
    double salary;
    public AddSalariedEmployee(int empID, String name, String adresse, double salary) {
        super(empID,name,adresse);
        this.salary=salary;
    }

    @Override
    public PaymentClassification makePaymentClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new MonthlyPaymentSchedule();
    }
}
