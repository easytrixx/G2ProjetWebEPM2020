package be.heh.epm.classification;

import be.heh.epm.payday.PayCheck;
import be.heh.epm.timecard.TimeCard;

import java.util.*;

public class HourlyClassification implements PaymentClassification{
    double salary;
    double hoursSalary;
    HashMap<Date, TimeCard> listTimeCard=new HashMap();
    public HourlyClassification(double hoursSalary){
        this.hoursSalary=hoursSalary;
    }
    @Override
    public double calculationSalary(){
        for(Map.Entry te: listTimeCard.entrySet()){
            TimeCard time=(TimeCard)te.getValue();
            if(time.getHours()>8){
                salary=hoursSalary*8+hoursSalary*(time.getHours()-8)*1.5;
            }
            else{
                salary=hoursSalary*time.getHours();
            }

        }
        return salary;
    }
    @Override
    public void calculationPay(PayCheck pc) {
        pc.setPay(this.calculationSalary());
    }

    public void addTimeCard(TimeCard t){
        listTimeCard.put(new Date(),t);
    }
    @Override
    public String toString(){
        return "par heure";
    }
}
