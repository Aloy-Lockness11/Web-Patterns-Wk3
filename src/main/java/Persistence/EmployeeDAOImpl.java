package Persistence;

import Business.Employee;
import Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends DAO implements EmployeeDAO {

    public EmployeeDAOImpl(String databaseName) {
        super(databaseName);
    }


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> Emplist = new ArrayList<>();

        Connection con = super.getConnection();

        try(PreparedStatement ps = con.prepareStatement("SELECT * from Employees")){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Employee e = new Employee(
                            rs.getInt("employeeNumber"),
                            rs.getString("lastName"),
                            rs.getString("firstName"),
                            rs.getString("extension"),
                            rs.getString("email"),
                            rs.getString("officeCode"),
                            rs.getInt("reportsTo"),
                            rs.getString("jobTitle")
                    );
                    Emplist.add(e);
                }
            }catch(SQLException e){
                System.out.println(LocalDateTime.now() + ": An SQLException  occurred while running the query" +
                        " or processing the result.");
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }catch(SQLException e){
            System.out.println(LocalDateTime.now() + ": An SQLException  occurred while preparing the SQL " +
                    "statement.");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        super.freeConnection(con);

        return Emplist;

    }
}
