package be.heh.epm.employee;

public interface EmployeeGateway {
    public Employee getEmployee(int id);
    public void save(int id, Employee employee);
    public void deleteEmployed(int id);
}
