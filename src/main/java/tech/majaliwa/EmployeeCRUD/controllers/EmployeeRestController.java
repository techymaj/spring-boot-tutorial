package tech.majaliwa.EmployeeCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.majaliwa.EmployeeCRUD.exceptions.EmployeeNotFoundException;
import tech.majaliwa.EmployeeCRUD.models.Employee;
import tech.majaliwa.EmployeeCRUD.services.EmployeeImpl;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {

    private final EmployeeImpl employee;

    @Autowired
    public EmployeeRestController(EmployeeImpl employee) {
        this.employee = employee;
    }

    @GetMapping("")
    public List<Employee> index() {
        return employee.allEmployees();
    }

    @GetMapping("/{employeeID}")
    public Employee employeeByID(@PathVariable int employeeID) {
        var foundEmployee = employee.getEmployeeByID(employeeID);
        if (foundEmployee != null) {
            return foundEmployee;
        }
        throw new EmployeeNotFoundException("No such employee with ID: " + employeeID);
    }
}
