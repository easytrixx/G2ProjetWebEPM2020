package be.heh.epm.transaction;

import be.heh.epm.employee.Command;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;

public abstract class ChangeEmployeeTransaction implements Command {
    private int EmpID;

    public ChangeEmployeeTransaction(int empID) {
        this.EmpID = empID;
    }

    public abstract void change(Employee employee);

    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(EmpID);
        if (e != null) {
            change(e);
        }
    }
}
