import java.util.Calendar;
import java.util.HashMap;
import java.util.ArrayList;
public class HourlyClassification implements PaymentClassification{
    double salary;
    double hoursSalary;
    ArrayList<TimeCard> listTimeCard=new ArrayList<TimeCard>();
    public HourlyClassification(double hoursSalary){
        this.hoursSalary=hoursSalary;
    }
    @Override
    public double calculationSalary(){
        for(TimeCard t : listTimeCard){
            salary+=t.hour*hoursSalary;
        }
        return salary;
    }
    public void addTimeCard(TimeCard t){
        listTimeCard.add(t);
    }
}
