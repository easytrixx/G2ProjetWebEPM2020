package be.heh.epm.transaction;

import be.heh.epm.employee.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String Name;

    public ChangeNameTransaction(int EmpID, String name) {
        super(EmpID);
        this.Name = name;
    }

    @Override
    public void change(Employee employee) {
        employee.setName(Name);
    }
}