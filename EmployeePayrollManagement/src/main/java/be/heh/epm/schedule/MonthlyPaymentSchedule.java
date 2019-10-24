package be.heh.epm.schedule;

public class MonthlyPaymentSchedule implements PaymentSchedule {
    @Override
    public String choiceDate() {
        return "par mois";
    }
}
