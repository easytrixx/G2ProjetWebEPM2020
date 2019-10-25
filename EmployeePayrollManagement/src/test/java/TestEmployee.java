import be.heh.epm.classification.HourlyClassification;
import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.classification.SalariedClassification;
import be.heh.epm.commission.CommisionnedClassification;
import be.heh.epm.commission.SalesReceipt;
import be.heh.epm.employee.Employee;
import be.heh.epm.method.DirectDepositMethod;
import be.heh.epm.method.MailMethod;
import be.heh.epm.method.PaymentMethod;
import be.heh.epm.schedule.DoubleWeekSchedule;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.PaymentSchedule;
import be.heh.epm.schedule.WeeklyPaymentSchedule;
import be.heh.epm.timecard.TimeCard;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;



public class TestEmployee {
    private Employee employee;
    @Before
    public void setUp() throws Exception {
        employee = new Employee(100,"toto","av maistriau");
    }
    @Test
    public void createSalariedEmployee() {

        employee.setPayClassification(new SalariedClassification(1000));
        employee.setPayMethod(new DirectDepositMethod("ING","be80-4444-444"));
        employee.setPaySchedule(new MonthlyPaymentSchedule());

        assertEquals(1000.0,employee.calculatePay(),0.01);

        PaymentSchedule ps = employee.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentSchedule);


        PaymentMethod pm = employee.getPayMethod();
        assertEquals("direct deposit into ING : be80-4444-444",pm.toString());

    }
    @Test
    public void createHourlyEmployee() {

        employee.setPayClassification(new HourlyClassification(20.0));
        employee.setPayMethod(new MailMethod("toto@gmail.com"));
        employee.setPaySchedule(new WeeklyPaymentSchedule());

        Calendar date = new GregorianCalendar(2019,10,1);
        Calendar nextDate = new GregorianCalendar(2019,10,2);
        PaymentClassification classification= employee.getPayClassification();
        ((HourlyClassification)classification).addTimeCard(new TimeCard(date, 8.0));
        ((HourlyClassification)classification).addTimeCard(new TimeCard(nextDate, 10.0));

        assertEquals(200,employee.calculatePay(),0.01);

        PaymentSchedule ps = employee.getPaySchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = employee.getPayMethod();
        assertEquals("mail : toto@gmail.com",pm.toString());
    }
    @Test
    public void createCommisionnedEmployee(){
        employee.setPayClassification(new CommisionnedClassification(2000.0,0.20));
        employee.setPayMethod(new MailMethod("toto@gmail.com"));
        employee.setPaySchedule(new DoubleWeekSchedule());
        Calendar date = new GregorianCalendar(2019,10,1);
        Calendar nextDate = new GregorianCalendar(2019,10,2);
        PaymentClassification classification= employee.getPayClassification();
        ((CommisionnedClassification)classification).addSaleReceipt(new SalesReceipt(date, 200));
        ((CommisionnedClassification)classification).addSaleReceipt(new SalesReceipt(nextDate, 500));
        assertEquals(2140.0,employee.calculatePay(),0.01);

        PaymentSchedule ps = employee.getPaySchedule();
        assertTrue(ps instanceof DoubleWeekSchedule);

        PaymentMethod pm = employee.getPayMethod();
        assertEquals("mail : toto@gmail.com",pm.toString());
    }
}