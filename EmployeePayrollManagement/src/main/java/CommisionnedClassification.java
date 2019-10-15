import java.util.Calendar;
import java.util.HashMap;
import java.util.ArrayList;
public class CommisionnedClassification implements PaymentClassification {
    double salary;
    double commission;
    double commissionTotal;
    ArrayList<SalesReceipt> listSaleReceipt=new ArrayList<SalesReceipt>();
    public CommisionnedClassification(double salary, double commission){
        this.salary=salary;
        this.commission=commission;
    }
    @Override
    public double calculationSalary() {
        for(SalesReceipt sales : listSaleReceipt){
            commissionTotal=sales.salesAmount*commission;
            salary+=commissionTotal;
        }
        return salary;
    }
    public void addSaleReceipt(SalesReceipt s){
        listSaleReceipt.add(s);
    }
}
