import be.heh.epm.hourly.AddHourlyEmployee;
import be.heh.epm.payday.PayCheck;
import be.heh.epm.payday.PayDay;
import be.heh.epm.timecard.AddTimeCard;
import be.heh.epm.timecard.TimeCard;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPayDayHourlyEmployee {
    private final LocalDate firstFriday=LocalDate.of(2019, Month.NOVEMBER, 1);
    private final LocalDate secondFriday=LocalDate.of(2019, Month.NOVEMBER, 8);
    private final LocalDate wrongDate=LocalDate.of(2019, Month.NOVEMBER, 2);
    @Before
    public void setup(){
        TestSetup.setupContext();
    }
    @Test
    public void PaySingleHourlyEmployeeWithoutHour(){
        int empID = 1;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empID,"toto","Rue de Nimy",20);
        hourlyEmployee.execute();
        PayDay payday = new PayDay(firstFriday);
        payday.execute();
        PayCheck pc = payday.getPayCheck(empID);
        assertNotNull(pc);
        assertEquals(firstFriday,pc.getDate());
        assertEquals(0,pc.getSalary(),0.1);
        assertEquals("Bank",pc.getField("Disposition"));
    }
    @Test
    public void PaySingleHourlyEmployeeOnWrongDate(){
        int empID = 5;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empID,"toto","Rue de Nimy",1400.0);
        hourlyEmployee.execute();
        PayDay payday = new PayDay(wrongDate);
        payday.execute();
        PayCheck pc = payday.getPayCheck(empID);
        assertNull(pc);
    }
    @Test
    public void PaySingleHourlyEmployeeWithHour(){
        int empID = 1;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(empID,"toto","Rue de Nimy",20);
        hourlyEmployee.execute();
        AddTimeCard tc=new AddTimeCard(empID,secondFriday,3);
        tc.execute();
        PayDay payday = new PayDay(secondFriday);
        payday.execute();
        PayCheck pc = payday.getPayCheck(empID);
        assertNotNull(pc);
        assertEquals(secondFriday,pc.getDate());
        assertEquals(60,pc.getSalary(),0.1);
        assertEquals("Bank",pc.getField("Disposition"));
    }
}
