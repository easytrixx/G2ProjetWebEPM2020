import be.heh.epm.employee.Context;

public class TestSetup {
    public static void setupContext(){
        Context.emp=new InMemoryEmployeeGateway();
    }
}
