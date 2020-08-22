package be.heh.epm.classification;

import be.heh.epm.payday.PayCheck;

public class SalariedClassification implements PaymentClassification {
    double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculationSalary() {
        return salary;
    }

    @Override
    public void calculationPay(PayCheck pc) {
        pc.setPay(this.calculationSalary());
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "salaried";
    }
}
