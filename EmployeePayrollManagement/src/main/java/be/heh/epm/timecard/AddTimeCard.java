package be.heh.epm.timecard;

import be.heh.epm.classification.HourlyClassification;
import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.employee.Command;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;

import java.time.LocalDate;

public class AddTimeCard implements Command {
    int empId;
    LocalDate date;
    double hours;
    TimeCard card;
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setCard(TimeCard card) {
        this.card = card;
    }

    public int getEmpId() {
        return empId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }

    public TimeCard getCard() {
        return card;
    }

    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(empId);
        PaymentClassification ps = e.getPayClassification();
        if(e!=null) {
            if(ps instanceof HourlyClassification){
                HourlyClassification u=(HourlyClassification) ps;
                card=new TimeCard(date,hours);
                u.addTimeCard(card);
                Context.emp.save(e.getId(),e);
            }
            else{
                throw new IllegalStateException("Pas le bon type");
            }
        }
        else{
            throw new NullPointerException("Aucun objet");
        }
    }
    public AddTimeCard(int id, LocalDate date, double hours){
        this.date=date;
        this.hours=hours;
        this.empId = id;
    }
}
