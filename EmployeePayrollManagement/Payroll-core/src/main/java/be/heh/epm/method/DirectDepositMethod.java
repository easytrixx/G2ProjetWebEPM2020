package be.heh.epm.method;

import be.heh.epm.payday.PayCheck;

public class DirectDepositMethod implements PaymentMethod{
    String name;
    String account;
    public DirectDepositMethod(String name, String account){
        this.name=name;
        this.account=account;
    }

    @Override
    public String toString() {
        return "Bank";
    }

    @Override
    public void pay(PayCheck pc) {
        pc.setDisposition("Bank");
    }
}
