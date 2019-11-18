import be.heh.epm.commission.AddCommisionnedEmployee;
import be.heh.epm.commission.AddCommission;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

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
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 1);
        AddCommission atc=new AddCommission(date,40,empId);
        atc.execute();
        assertEquals(atc.getDate(),atc.getSr().getDate());
        assertEquals(atc.getAmount(),atc.getSr().getSalesAmount(),0.01);
    }
}
