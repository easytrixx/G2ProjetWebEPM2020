package be.heh.epm.classification;

import be.heh.epm.payday.PayCheck;

public interface PaymentClassification {
    public double calculationSalary();
    public void calculationPay(PayCheck pc);
}
