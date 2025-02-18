package tech.majaliwa.EmployeeCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public List<Employee> getAllEmployees() {
        return employee.allEmployees();
    }

    @GetMapping("/{employeeID}")
    public Employee getEmployeeByID(@PathVariable int employeeID) {
        var foundEmployee = employee.getEmployeeByID(employeeID);
        if (foundEmployee != null) {
            return foundEmployee;
        }
        throw new EmployeeNotFoundException("No such employee with ID: " + employeeID);
    }

    @PostMapping("")
    public Employee addNewEmployee() {
        return employee.addNewEmployee(
                "Wilfried",
                "Majaliwa",
                "wilfriedmajaliwa@gmail.com"
        );
    }

    @PutMapping("/{employeeID}/{newEmail}")
    public Employee updateEmployeeEmail(
            @PathVariable int employeeID,
            @PathVariable String newEmail
    ) {
        return employee.updateEmployeeEmail(employeeID, newEmail);
    }

    @DeleteMapping("/{employeeID}")
    public String deleteEmployeeByID(@PathVariable int employeeID) {
        var foundEmployee = employee.getEmployeeByID(employeeID);
        if (foundEmployee != null) {
            employee.deleteEmployee(employeeID);
            return "Deleted employee with ID: " + employeeID;
        }
        throw new EmployeeNotFoundException("No such employee with ID: " + employeeID);
    }
}
