import java.util.*;

public class HourlyClassification implements PaymentClassification{
    double salary;
    double hoursSalary;
    HashMap<Date,TimeCard> listTimeCard=new HashMap();
    public HourlyClassification(double hoursSalary){
        this.hoursSalary=hoursSalary;
    }
    @Override
    public double calculationSalary(){
        for(Map.Entry te: listTimeCard.entrySet()){
            TimeCard time=(TimeCard)te.getValue();
            salary=hoursSalary*time.getHours();
        }
        return salary;
    }
    public void addTimeCard(TimeCard t){
        listTimeCard.put(new Date(),t);
    }
}
