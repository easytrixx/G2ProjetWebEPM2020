public class MailMethod implements PaymentMethod{
    String mail;
    public MailMethod(String mail){
        this.mail=mail;
    }

    @Override
    public String toString() {
        return "mail : "+mail;
    }
}
