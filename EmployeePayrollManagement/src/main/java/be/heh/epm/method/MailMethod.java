package be.heh.epm.method;

import be.heh.epm.payday.PayCheck;

public class MailMethod implements PaymentMethod {
    String mail;
    public MailMethod(String mail){
        this.mail=mail;
    }

    @Override
    public String toString() {
        return "mail : "+mail;
    }

    @Override
    public void pay(PayCheck pc) {
        pc.setDisposition(this.toString());
    }
}
