package be.heh.epm.transaction;

import be.heh.epm.employee.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    private String Address;

    public ChangeAddressTransaction(int EmpID, String address) {
        super(EmpID);
        this.Address = address;
    }

    @Override
    public void change(Employee employee) {
        employee.setAdresse(Address);
    }
}
