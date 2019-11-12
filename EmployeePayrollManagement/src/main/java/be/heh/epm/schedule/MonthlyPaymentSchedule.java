package be.heh.epm.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class MonthlyPaymentSchedule implements PaymentSchedule {
    @Override
    public String choiceDate() {
        return "par mois";
    }

    @Override
    public boolean isPayDate(LocalDate date) {
        YearMonth month= YearMonth.from(date);
        LocalDate end=month.atEndOfMonth();
        if(date.isEqual(end)){
            return true;
        }
        else{
            return false;
        }
    }
}
