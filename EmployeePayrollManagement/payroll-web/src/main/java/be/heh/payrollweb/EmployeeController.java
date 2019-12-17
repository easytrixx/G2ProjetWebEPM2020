package be.heh.payrollweb;

import be.heh.epm.employee.Context;
import be.heh.epm.employee.GetAllEmployee;
import heh.SqlEmployeeGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin("*")
@RestController("/")
public class EmployeeController {
    @GetMapping
    public String listEmployee(){
        return "<h1>Test</h1>";
    }
    @GetMapping(value = "/employees")
    public Map getEmploye(){
        GetAllEmployee employee=new GetAllEmployee();
        return employee.getAllEmployee();
    }

}
