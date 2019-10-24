package be.heh.epm.classification;

public class SalariedClassification implements PaymentClassification{
    double salary;
    public SalariedClassification(double salary){
        this.salary=salary;
    }

    @Override
    public double calculationSalary() {
        return salary;
    }
}
