import static org.junit.Assert.*;

import be.heh.epm.employee.AddSalariedEmployee;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;
import be.heh.epm.method.PaymentMethod;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.PaymentSchedule;
import be.heh.epm.schedule.WeeklyPaymentSchedule;
import org.junit.Before;
import org.junit.Test;

public class TestAddEmployee {

    @Before
    public void setup(){
        TestSetup.setupContext();
    }

    @Test
    public void testAddSalariedEmployee () {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob","Home",1000.00);
        t.execute();

        Employee e = Context.emp.getEmployee(empId);
        assertEquals("Bob",e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis : be332211",pm.toString());
    }

    @Test
    public void testAddHourlyEmployee () {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "BobHourly","Home_Hourly",20.0);
        t.execute();

        Employee e = Context.emp.getEmployee(empId);
        assertEquals("BobHourly",e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis : be332211",pm.toString());
    }
    @Test
    public void testAddCommissionedEmployee () {
        int empId = 2;
        AddCommisionnedEmployee v = new AddCommisionnedEmployee(empId, "BobCommissioned","Home_Hourly",2000.0,0.30);
        v.execute();

        Employee e = Context.emp.getEmployee(empId);
        assertEquals("BobCommissioned",e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis : be332211",pm.toString());
    }
}