package be.heh.epm.transaction;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.commission.CommisionnedClassification;
import be.heh.epm.schedule.DoubleWeekSchedule;
import be.heh.epm.schedule.PaymentSchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {

    private double Salary;
    private double Rate;

    public ChangeCommissionedTransaction(int empID, double salary, double rate)
    {
        super(empID);
        this.Salary = salary;
        this.Rate = rate;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new DoubleWeekSchedule();
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommisionnedClassification(Salary, Rate);
    }
}