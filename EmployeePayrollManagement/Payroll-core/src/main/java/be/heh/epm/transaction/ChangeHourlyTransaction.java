package be.heh.epm.transaction;

import be.heh.epm.classification.HourlyClassification;
import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.schedule.PaymentSchedule;
import be.heh.epm.schedule.WeeklyPaymentSchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

    private double Salary;

    public ChangeHourlyTransaction(int empId, double salary)
    {
        super(empId);
        this.Salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(Salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklyPaymentSchedule();
    }
}