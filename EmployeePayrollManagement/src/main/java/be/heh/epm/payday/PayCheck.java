package be.heh.epm.payday;

import java.time.LocalDate;

public class PayCheck {
    LocalDate date;
    double salary;
    String methode;
    public PayCheck(LocalDate date){
        this.date=date;
    }
    public void setPay(double salary){
        this.salary=salary;
    }
    public void setDisposition(String s){
        this.methode=s;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getField(String disposition) {
        return this.methode;
    }
}
