package be.heh.emp.payrollweb;

import be.heh.epm.SqlEmployeeGateway;
import be.heh.epm.classification.HourlyClassification;
import be.heh.epm.classification.SalariedClassification;
import be.heh.epm.commission.CommisionnedClassification;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;
import be.heh.epm.method.DirectDepositMethod;
import be.heh.epm.method.MailMethod;
import be.heh.epm.schedule.DoubleWeekSchedule;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.WeeklyPaymentSchedule;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController("/")
public class UserController {


    @GetMapping(value = "/bonjour")
    public String bonjour() {
        return "bonjour";
    }


    @GetMapping(value = "/employeList")
    public String listEmploye() {

        SqlEmployeeGateway re = new SqlEmployeeGateway();
        ArrayList<Employee> liste = re.receiveAllEmployee();
        Gson json = new Gson();
        String reponse = json.toJson(liste);
        return reponse;
    }

    @RequestMapping(value = "/addEmploye", method = RequestMethod.POST)
    public String addEmploye(@RequestParam(value = "nom") String nom, @RequestParam(value = "addresse") String address,
                             @RequestParam(value = "method") String method, @RequestParam(value = "schedule") String schedule, @RequestParam(value = "type") String type) {
        int id = 1;
        Employee e;
        Context.emp = new SqlEmployeeGateway();
        e = new Employee(id, nom, address);
        if (method.equals("direct")) {
            e.setPayMethod(new DirectDepositMethod("ING", "BE-859858-85"));
        } else if (method.equals("mail")) {
            e.setPayMethod(new MailMethod(nom.toString() + "@hotmail.com"));
        } else {

        }
        if (schedule.equals("mois")) {
            e.setPaySchedule(new MonthlyPaymentSchedule());
        } else if (schedule.equals("semaine")) {
            e.setPaySchedule(new WeeklyPaymentSchedule());
        } else if (schedule.equals("2semaines")) {
            e.setPaySchedule(new DoubleWeekSchedule());
        } else {
        }
        if (type.equals("salarie")) {
            e.setPayClassification(new SalariedClassification(2000));
        } else if (type.equals("heure")) {
            e.setPayClassification(new HourlyClassification(50));
        } else if (type.equals("commission")) {
            e.setPayClassification(new CommisionnedClassification(5000, 20));
        } else {

        }
        Context.emp.save(id, e);

        return " Nom : " + nom + " address :  " + address + " method : " + method + " type de payement : " + schedule + " type : " + type;

    }

}
