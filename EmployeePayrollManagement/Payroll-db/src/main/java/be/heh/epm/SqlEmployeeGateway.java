package be.heh.epm;


import be.heh.epm.employee.Employee;
import be.heh.epm.employee.EmployeeGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SqlEmployeeGateway implements EmployeeGateway {
    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void save(int id, Employee employee) {
        DatabaseConnectionManager objet = new DatabaseConnectionManager("localhost", "postgres", "postgres", "test123");

        try {
            Connection connection = objet.getConnection();
            PreparedStatement requetePrepa = connection.prepareStatement("INSERT INTO employee(nom,address,type,methode,schedule) VALUES(?,?,?,?,?)");
            requetePrepa.setString(1, employee.getName());
            requetePrepa.setString(2, employee.getAdresse());
            requetePrepa.setString(3, employee.getPayClassification().toString());
            requetePrepa.setString(4, employee.getPayMethod().toString());
            requetePrepa.setString(5, employee.getPaySchedule().toString());
            requetePrepa.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployed(int id) {
        DatabaseConnectionManager objet = new DatabaseConnectionManager("localhost", "postgres", "postgres", "root");
        try {
            Connection connection = objet.getConnection();
            PreparedStatement requetePrepa = connection.prepareStatement("DELETE FROM employee WHERE id=?");
            requetePrepa.setInt(1, id);
            requetePrepa.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map getAllEmployees() {
        Map hm = new HashMap();
        DatabaseConnectionManager objet = new DatabaseConnectionManager("localhost", "postgres", "postgres", "root");
        String SQL = "Select * FROM employee";
        try {
            Connection connection = objet.getConnection();
            PreparedStatement requetePrepa = connection.prepareStatement(SQL);
            ResultSet rs = requetePrepa.executeQuery();
            while (rs.next()) {
                hm.put(rs.getInt("id"), rs.getString("nom"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hm;
    }

    @Override
    public ArrayList<Employee> receiveAllEmployee() {
        ArrayList<Employee> hm = new ArrayList<>();
        DatabaseConnectionManager objet = new DatabaseConnectionManager("localhost", "postgres", "postgres", "root");
        String SQL = "Select * FROM employee";
        try {
            Connection connection = objet.getConnection();
            PreparedStatement requetePrepa = connection.prepareStatement(SQL);
            ResultSet rs = requetePrepa.executeQuery();
            while (rs.next()) {
                hm.add(new Employee(rs.getInt("id"), rs.getString("nom"), rs.getString("address")));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hm;
    }
}
