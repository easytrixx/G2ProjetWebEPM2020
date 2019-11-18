package be.heh.epm.commission;

import java.time.LocalDate;

public class SalesReceipt {
    public LocalDate getDate() {
        return date;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    LocalDate date;
    double salesAmount;
    public SalesReceipt(LocalDate date, double salesAmount){
        this.date=date;
        this.salesAmount=salesAmount;
    }
}
