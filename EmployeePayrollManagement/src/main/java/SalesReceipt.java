import java.util.Calendar;

public class SalesReceipt {
    public Calendar getDate() {
        return date;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    Calendar date;
    double salesAmount;
    public SalesReceipt(Calendar date, double salesAmount){
        this.date=date;
        this.salesAmount=salesAmount;
    }
}
