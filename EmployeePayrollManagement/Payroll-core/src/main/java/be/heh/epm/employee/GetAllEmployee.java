package be.heh.epm.employee;

import heh.SqlEmployeeGateway;

import java.util.Map;

public class GetAllEmployee implements EmployeeGateway{
    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void save(int id, Employee employee) {
    }

    @Override
    public void deleteEmployed(int id) {

    }

    @Override
    public Map getAllEmployee() {
        Context.emp=new SqlEmployeeGateway();
        return Context.emp.getAllEmployee();
    }
}
