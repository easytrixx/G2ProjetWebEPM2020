public class Employee{
    String name;
    String adresse;
    int id;
    PaymentSchedule paySchedule;
    PaymentMethod payMethod;
    PaymentClassification payClassification;
    public Employee(int id, String name, String adresse){
        if(id>0) {
            this.name = name;
            this.adresse = adresse;
            this.id = id;
        }
    }
    public void setPayClassification(PaymentClassification payClassification){
        this.payClassification=payClassification;
    }
    public void setPayMethod(PaymentMethod payMethod){
        this.payMethod=payMethod;
    }
    public void setPaySchedule(PaymentSchedule PaySchedule){
        this.paySchedule=PaySchedule;
    }
    public double calculatePay(){
        return this.payClassification.calculationSalary();
    }

    public PaymentSchedule getPaySchedule() {
        return paySchedule;
    }

    public PaymentMethod getPayMethod() {
        return  payMethod;
    }

    public PaymentClassification getPayClassification() {
        return payClassification;
    }
}
