package be.heh.epm.transaction;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.classification.SalariedClassification;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.PaymentSchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

    private double Salary;

    public ChangeSalariedTransaction(int empID, double salary) {
        super(empID);
        this.Salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(Salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlyPaymentSchedule();
    }
}
