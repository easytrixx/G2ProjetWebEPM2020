package be.heh.epm.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyPaymentSchedule implements PaymentSchedule {
    @Override
    public String choiceDate() {
        return "LOL";
    }

    @Override
    public boolean isPayDate(LocalDate date) {
        DayOfWeek jour=date.getDayOfWeek();
        int jourInt=jour.getValue();
        if(jourInt==5){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "par semaine";
    }
}
