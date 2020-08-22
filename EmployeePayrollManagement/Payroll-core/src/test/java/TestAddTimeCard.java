
import be.heh.epm.hourly.AddHourlyEmployee;
import be.heh.epm.timecard.AddTimeCard;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class TestAddTimeCard {
    @Before
    public void setup() {
        TestSetup.setupContext();
    }

    @Test
    public void testAddTimeCard() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 20.0);
        t.execute();
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 1);
        AddTimeCard atc = new AddTimeCard(empId, date, 20);
        atc.execute();
        assertEquals(atc.getHours(), t.getHours(), 0.01);
        assertEquals(atc.getDate(), atc.getCard().getDate());
    }
}
