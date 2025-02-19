package tech.majaliwa.EmployeeCRUD.services;

import tech.majaliwa.EmployeeCRUD.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> allEmployees();
    Employee getEmployeeByID(int id);
    Employee addNewEmployee(String fName, String lName, String email);
    Employee updateEmployeeEmail(int id, String email);
    void deleteEmployee(int id);
}
