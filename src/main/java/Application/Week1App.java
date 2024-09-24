package Application;

import Business.Employee;
import Persistence.EmployeeDAO;
import Persistence.EmployeeDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class Week1App {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        EmployeeDAO empD = new EmployeeDAOImpl("classicmodels");
        employees = empD.getAllEmployees();

        for (Employee e: employees) {
            System.out.println(e.toString());
        }
    }
}
