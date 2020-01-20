
import be.heh.epm.classification.SalariedClassification;
import be.heh.epm.employee.Context;
import be.heh.epm.employee.Employee;
import be.heh.epm.method.DirectDepositMethod;
import be.heh.epm.schedule.MonthlyPaymentSchedule;
import be.heh.epm.DatabaseConnectionManager;
import be.heh.epm.SqlEmployeeGateway;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class TestSqlEmployee {
    private Connection connection;
    private Employee e;


    @Before
    public void setup() {
        Context.emp = new SqlEmployeeGateway();
        cleanTableEmploye();
        e = new Employee(55, "tototo", "Av. Maistriau");
        e.setPayClassification(new SalariedClassification(2000));
        e.setPaySchedule(new MonthlyPaymentSchedule());
        e.setPayMethod(new DirectDepositMethod("ING", "BE-123-456-789"));
        DatabaseConnectionManager objet = new DatabaseConnectionManager("localhost", "postgres", "postgres", "root");
        try {
            connection = objet.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    private void cleanTableEmploye(){
        DatabaseConnectionManager objetmanager = new DatabaseConnectionManager("localhost","postgres","postgres", "root");
        try {
            String delete = "DELETE FROM employee";
            Connection connection = objetmanager.getConnection();
            PreparedStatement statement  = connection.prepareStatement(delete);
            statement.execute();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void addEmployee(){
        Context.emp.save(54,e);
        try{
            String select="SELECT * FROM employee";
            PreparedStatement statement=connection.prepareStatement(select);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                assertEquals(55,rs.getInt("id"));
                assertEquals("tototo",rs.getString("nom"));
                assertEquals("Av. Maistriau",rs.getString("address"));
                assertEquals("par mois",rs.getString("schedule"));
                assertEquals("Bank",rs.getString("method"));
                assertEquals("salaried",rs.getString("type"));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}