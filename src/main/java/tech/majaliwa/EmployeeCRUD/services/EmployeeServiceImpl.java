package tech.majaliwa.EmployeeCRUD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.majaliwa.EmployeeCRUD.dao.EmployeeDAO;
import tech.majaliwa.EmployeeCRUD.models.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> allEmployees() {
        return employeeDAO.allEmployees();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeDAO.getEmployeeByID(id);
    }

    @Override
    public Employee addNewEmployee(String fName, String lName, String email) {
        return employeeDAO.addNewEmployee(fName, lName, email);
    }

    @Override
    public Employee updateEmployeeEmail(int id, String email) {
        return employeeDAO.updateEmployeeEmail(id, email);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
