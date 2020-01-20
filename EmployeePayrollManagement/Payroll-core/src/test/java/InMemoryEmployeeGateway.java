import be.heh.epm.employee.Employee;
import be.heh.epm.employee.EmployeeGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryEmployeeGateway implements EmployeeGateway {
    private Map<Integer, Employee> employees=new HashMap();
    @Override
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    @Override
    public void save(int id, Employee employee) {
        employees.put(id,employee);
    }
    @Override
    public void deleteEmployed(int id) {
        employees.remove(id);
    }

    @Override
    public Map getAllEmployees() {
        return null;
    }

    @Override
    public ArrayList<Employee> receiveAllEmployee() {
        return null;
    }

}
