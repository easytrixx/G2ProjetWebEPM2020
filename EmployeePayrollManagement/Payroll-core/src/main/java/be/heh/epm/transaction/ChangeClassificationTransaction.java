package be.heh.epm.transaction;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.employee.Employee;
import be.heh.epm.schedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(int Empid) {
        super(Empid);
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    @Override
    public void change(Employee employee) {
        employee.setPayClassification(getClassification());
        employee.setPaySchedule(getSchedule());
    }
}
