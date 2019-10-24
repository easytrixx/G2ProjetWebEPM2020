import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TestAddCommission {
    @Before
    public void setup(){
        TestSetup.setupContext();
    }

    @Test
    public void testAddCommission () {
        int empId=1;
        AddCommisionnedEmployee c = new AddCommisionnedEmployee(empId, "Bob","Home",20.0,0.3);
        c.execute();
        Calendar date = new GregorianCalendar(2019,10,1);
        AddCommission atc=new AddCommission(date,40,empId);
        atc.execute();
        assertEquals(atc.date,atc.sr.getDate());
        assertEquals(atc.amount,atc.sr.getSalesAmount(),0.01);
    }
}
