package be.heh.epm.hourly;
import be.heh.epm.employee.AddEmployee;
import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.classification.HourlyClassification;
import be.heh.epm.schedule.PaymentSchedule;
import be.heh.epm.schedule.WeeklyPaymentSchedule;

public class AddHourlyEmployee extends AddEmployee {
    public double getHours() {
        return hourlyRate;
    }

    double hourlyRate;
    public AddHourlyEmployee(int id, String name, String adresse, double hourlyRate){
        super(id,name,adresse);
        this.hourlyRate=hourlyRate;
    }
    @Override
    public PaymentClassification makePaymentClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new WeeklyPaymentSchedule();
    }
}
