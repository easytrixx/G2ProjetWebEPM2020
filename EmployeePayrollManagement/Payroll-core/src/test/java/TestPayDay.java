import be.heh.epm.employee.AddSalariedEmployee;
import be.heh.epm.payday.PayCheck;
import be.heh.epm.payday.PayDay;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPayDay {
    @Before
    public void setup() {
        TestSetup.setupContext();
    }

    @Test
    public void PaySingleSalariedEmployee() {
        int empID = 1;
        AddSalariedEmployee salariedEmployee = new AddSalariedEmployee(empID, "toto", "Rue de Nimy", 1400.0);
        salariedEmployee.execute();

        LocalDate date = LocalDate.of(2019, Month.NOVEMBER, 30);
        PayDay payday = new PayDay(date);
        payday.execute();
        PayCheck pc = payday.getPayCheck(empID);
        assertNotNull(pc);
        assertEquals(date, pc.getDate());
        assertEquals(1400.0, pc.getSalary(), 0.1);
        assertEquals("Bank", pc.getField("Disposition"));

    }

    @Test
    public void PaySingleSalariedEmployeeOnWrongDate() {
        int empID = 5;
        AddSalariedEmployee salariedEmployee = new AddSalariedEmployee(empID, "toto", "Rue de Nimy", 1400.0);
        salariedEmployee.execute();
        LocalDate date = LocalDate.of(2019, Month.NOVEMBER, 28);
        PayDay payday = new PayDay(date);
        payday.execute();
        PayCheck pc = payday.getPayCheck(empID);
        assertNull(pc);
    }
}
