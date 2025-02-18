package tech.majaliwa.EmployeeCRUD.dao;

import tech.majaliwa.EmployeeCRUD.models.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> allEmployees();
    Employee getEmployeeByID(int id);
    Employee addNewEmployee(String fName, String lName, String email);
}
