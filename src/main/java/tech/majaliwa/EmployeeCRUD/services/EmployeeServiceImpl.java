package tech.majaliwa.EmployeeCRUD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.majaliwa.EmployeeCRUD.exceptions.EmployeeNotFoundException;
import tech.majaliwa.EmployeeCRUD.models.Employee;
import tech.majaliwa.EmployeeCRUD.dao.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("No such employee with ID: " + id)
        );
    }

    @Override
    public Employee addNewEmployee(String fName, String lName, String email) {
        Employee employee = new Employee(fName, lName, email);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeEmail(int id, String email) {
        var employee = employeeRepository.findById(id).orElseThrow();
        employee.setEmail(email);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("No such employee with ID: " + id)
        );
        employeeRepository.delete(employee);
    }
}
