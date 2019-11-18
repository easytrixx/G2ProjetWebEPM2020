package be.heh.epm.timecard;

import java.time.LocalDate;

public class TimeCard {
    LocalDate date;
    double hour;
    public TimeCard(LocalDate date, double hour){
        this.date=date;
        this.hour=hour;
    }

    public double getHours() {
        return hour;
    }

    public LocalDate getDate() {
        return date;
    }
}
