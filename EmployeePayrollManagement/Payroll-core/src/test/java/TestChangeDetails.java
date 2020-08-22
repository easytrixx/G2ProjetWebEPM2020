import be.heh.epm.classification.PaymentClassification;
import be.heh.epm.classification.SalariedClassification;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;
import be.heh.epm.hourly.AddHourlyEmployee;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.schedule.PaymentSchedule;
import be.heh.epm.transaction.ChangeAddressTransaction;
import be.heh.epm.transaction.ChangeNameTransaction;
import be.heh.epm.transaction.ChangeSalariedTransaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.err;

public class TestChangeDetails {
    @Before
    public void setup() {
        TestSetup.setupContext();
    }

    @Test
    public void testChangeAddressTransaction() throws Exception {
        err.println("TestChangeAddressTransaction");
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 15.25);
        t.execute();
        ChangeAddressTransaction cat = new ChangeAddressTransaction(empId, "Work");
        cat.execute();

        Employee e = Context.emp.getEmployee(empId);
        Assert.assertNotNull(e);
        Assert.assertEquals("Work", e.getAdresse());
    }

    @Test
    public void testChangeNameTransaction() throws Exception {
        err.println("TestChangeNameTransaction");
        int empId = 3;
        AddHourlyEmployee h = new AddHourlyEmployee(empId, "Bob", "Home", 15.25);
        h.execute();
        ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Joseph");
        cnt.execute();

        Employee e = Context.emp.getEmployee(empId);
        Assert.assertNotNull(e);
        Assert.assertEquals("Joseph", e.getName());
    }

    @Test
    public void testChangeSalariedTransaction() throws Exception {
        err.println("TestChangeSalariedTransaction");
        int empId = 4;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Lance", "Home", 15.25);
        t.execute();

        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 1000.00);
        cst.execute();

        Employee e = Context.emp.getEmployee(empId);
        Assert.assertNotNull(e);

        PaymentClassification pc = e.getPayClassification();
        Assert.assertNotNull(pc);
        SalariedClassification sc = (SalariedClassification) pc;
        Assert.assertNotNull(sc);

        Assert.assertEquals(1000.00, sc.getSalary(), 0.001);
        PaymentSchedule ps = e.getPaySchedule();
        MonthlyPaymentSchedule ms = (MonthlyPaymentSchedule) ps;
        Assert.assertNotNull(ms);
    }
}