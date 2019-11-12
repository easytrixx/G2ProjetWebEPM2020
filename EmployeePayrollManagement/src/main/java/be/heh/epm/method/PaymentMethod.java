package be.heh.epm.method;

import be.heh.epm.payday.PayCheck;

public interface PaymentMethod {
    public void pay(PayCheck pc);
}
