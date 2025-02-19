package tech.majaliwa.EmployeeCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.majaliwa.EmployeeCRUD.exceptions.EmployeeNotFoundException;
import tech.majaliwa.EmployeeCRUD.models.Employee;
import tech.majaliwa.EmployeeCRUD.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.allEmployees();
    }

    @GetMapping("/{employeeID}")
    public Employee getEmployeeByID(@PathVariable int employeeID) {
        var foundEmployee = employeeService.getEmployeeByID(employeeID);
        if (foundEmployee != null) {
            return foundEmployee;
        }
        throw new EmployeeNotFoundException("No such employee with ID: " + employeeID);
    }

    @PostMapping("")
    public Employee addNewEmployee() {
        return employeeService.addNewEmployee(
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
        return employeeService.updateEmployeeEmail(employeeID, newEmail);
    }

    @DeleteMapping("/{employeeID}")
    public String deleteEmployeeByID(@PathVariable int employeeID) {
        var foundEmployee = employeeService.getEmployeeByID(employeeID);
        if (foundEmployee != null) {
            employeeService.deleteEmployee(employeeID);
            return "Deleted employee with ID: " + employeeID;
        }
        throw new EmployeeNotFoundException("No such employee with ID: " + employeeID);
    }
}
