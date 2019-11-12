package be.heh.epm.schedule;

import java.time.LocalDate;

public interface PaymentSchedule {
    public String choiceDate();
    public boolean isPayDate(LocalDate date);
}
