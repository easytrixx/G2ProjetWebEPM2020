import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddTimeCard implements Command {
    int empId;
    Calendar date;
    double hours;
    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(empId);
        PaymentClassification ps = e.getPayClassification();
        if(e!=null) {
            if(ps instanceof HourlyClassification){
                HourlyClassification u=(HourlyClassification) ps;
                AddTimeCard tm=new AddTimeCard(empId,date,hours);
            }
            else{
                throw new IllegalStateException("Pas le bon type");
            }
        }
        else{
            throw new NullPointerException("Aucun objet");
        }
    }
    public AddTimeCard(int id, Calendar date, double hours){
        this.date=date;
        this.hours=hours;
        this.empId = id;
    }
}
