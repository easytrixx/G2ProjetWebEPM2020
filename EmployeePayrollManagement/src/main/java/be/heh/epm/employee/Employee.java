package be.heh.epm.employee;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.method.PaymentMethod;
import be.heh.epm.payday.PayCheck;
import be.heh.epm.schedule.PaymentSchedule;

import java.time.LocalDate;

public class Employee{
    String name;
    String adresse;
    int id;
    PaymentSchedule paySchedule;
    PaymentMethod payMethod;
    PaymentClassification payClassification;
    public Employee(int id, String name, String adresse){
        if(id>0) {
            this.name = name;
            this.adresse = adresse;
            this.id = id;
        }
    }
    public void setPayClassification(PaymentClassification payClassification){
        this.payClassification=payClassification;
    }
    public void setPayMethod(PaymentMethod payMethod){
        this.payMethod=payMethod;
    }
    public void setPaySchedule(PaymentSchedule PaySchedule){
        this.paySchedule=PaySchedule;
    }
    public double calculatePay(){
        return this.payClassification.calculationSalary();
    }

    public PaymentSchedule getPaySchedule() {
        return paySchedule;
    }

    public PaymentMethod getPayMethod() {
        return  payMethod;
    }

    public PaymentClassification getPayClassification() {
        return payClassification;
    }
    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdresse() {
        return adresse;
    }
    public boolean isPayDate(LocalDate date){
        return this.paySchedule.isPayDate(date);
    }

    public void payDay(PayCheck pc) {
        this.payClassification.calculationPay(pc);
        this.payMethod.pay(pc);
    }
}
