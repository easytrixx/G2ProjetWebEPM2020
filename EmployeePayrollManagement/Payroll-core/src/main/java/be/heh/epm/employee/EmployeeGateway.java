package be.heh.epm.employee;

import java.util.Map;

public interface EmployeeGateway {
    public Employee getEmployee(int id);
    public void save(int id, Employee employee);
    public void deleteEmployed(int id);
    public Map getAllEmployee();
}