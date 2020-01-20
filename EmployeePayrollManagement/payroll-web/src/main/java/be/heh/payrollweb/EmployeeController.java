package be.heh.payrollweb;

import be.heh.epm.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController("/")
public class EmployeeController {
    @GetMapping
    public String listEmployee(){
        return "<h1>Test</h1>";
    }
    @GetMapping(value  ="/employeList")
    public ArrayList<String> listEmploye(){

        /*ReadEmployee re  = new ReadEmployee();
        ArrayList<Employee> liste = re.getAllEmployee();
        ArrayList<String> liste2 = new ArrayList<>();



        for(Employee e : liste){
            liste2.add(e.getName());
            liste2.add(e.getAdresse());


        }
        return liste2;*/
        return null;
    }

}
