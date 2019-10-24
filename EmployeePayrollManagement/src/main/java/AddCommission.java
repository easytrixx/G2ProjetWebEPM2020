import java.util.Calendar;

public class AddCommission implements Command {
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
