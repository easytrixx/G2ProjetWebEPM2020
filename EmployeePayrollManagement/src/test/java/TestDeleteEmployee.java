import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDeleteEmployee {
    @Before
    public void setup(){
        TestSetup.setupContext();
    }

    @Test
    public void testDeleteEmployee () {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob","Home",1000.00);
        t.execute();
        Employee e = Context.emp.getEmployee(empId);
        assertNotNull(e);
        DeleteEmployee v = new DeleteEmployee(empId);
        v.execute();
        e = Context.emp.getEmployee(empId);
        assertNull(e);
    }
}
