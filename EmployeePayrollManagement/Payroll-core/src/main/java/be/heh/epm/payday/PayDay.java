package be.heh.epm.payday;

import be.heh.epm.employee.Command;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PayDay implements Command {
    LocalDate date;
    Map<Integer, PayCheck> listepc = new HashMap<>();

    public PayDay(LocalDate date) {
        this.date = date;
    }

    @Override
    public void execute() {
        Map listeEmployee = Context.emp.getAllEmployees();
        listeEmployee.forEach((k, v) -> {
            int id = (int) k;
            Employee e = (Employee) v;
            if (e.isPayDate(date) == true) {
                PayCheck pc = new PayCheck(date);
                e.payDay(pc);
                listepc.put(id, pc);
            }
        });
    }

    public PayCheck getPayCheck(int empID) {
        PayCheck pc = listepc.get(empID);
        return pc;
    }
}
