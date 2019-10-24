package be.heh.epm.commission;

import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.employee.Command;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;

import java.util.Calendar;

public class AddCommission implements Command {
    public Calendar getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getEmpId() {
        return empId;
    }

    public SalesReceipt getSr() {
        return sr;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setSr(SalesReceipt sr) {
        this.sr = sr;
    }

    Calendar date;
    double amount;
    int empId;
    SalesReceipt sr;
    public AddCommission(Calendar date, double amount, int empId) {
        this.date=date;
        this.amount=amount;
        this.empId=empId;
    }

    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(empId);
        PaymentClassification ps = e.getPayClassification();
        if(e!=null) {
            if(ps instanceof CommisionnedClassification){
                CommisionnedClassification u=(CommisionnedClassification) ps;
                sr=new SalesReceipt(date,amount);
            }
            else{
                throw new IllegalStateException("Pas le bon type");
            }
        }
        else{
            throw new NullPointerException("Aucun objet");
        }
    }
}
