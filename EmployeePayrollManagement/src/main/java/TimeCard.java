import java.util.Calendar;

public class TimeCard {
    Calendar date;
    double hour;
    public TimeCard(Calendar date, double hour){
        this.date=date;
        this.hour=hour;
    }

    public double getHours() {
        return hour;
    }
}
