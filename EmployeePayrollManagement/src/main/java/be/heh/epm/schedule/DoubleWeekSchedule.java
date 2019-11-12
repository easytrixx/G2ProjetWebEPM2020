package be.heh.epm.schedule;

import java.time.LocalDate;

public class DoubleWeekSchedule implements PaymentSchedule{
    @Override
    public String choiceDate() {
        return "LOL";
    }

    @Override
    public boolean isPayDate(LocalDate date) {
        return false;
    }
}
