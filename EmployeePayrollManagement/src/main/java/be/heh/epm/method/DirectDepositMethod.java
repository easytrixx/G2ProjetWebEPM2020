package be.heh.epm.method;

public class DirectDepositMethod implements PaymentMethod{
    String name;
    String account;
    public DirectDepositMethod(String name, String account){
        this.name=name;
        this.account=account;
    }

    @Override
    public String toString() {
        return "direct deposit into "+name+" : "+account;
    }
}
