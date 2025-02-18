package tech.majaliwa.EmployeeCRUD.services;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import tech.majaliwa.EmployeeCRUD.dao.EmployeeDAO;
import tech.majaliwa.EmployeeCRUD.models.Employee;

import java.util.List;

@Controller
public class EmployeeImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeImpl(EntityManager entityManager1) {
        this.entityManager = entityManager1;
    }

    @Override
    public List<Employee> allEmployees() {
        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        var employee = entityManager.find(Employee.class, id);

        if (employee.getId() == id) {
            return employee;
        }
        return null;
    }

    @Override
    @Transactional
    public Employee addNewEmployee(String fName, String lName, String email) {
        Employee newEmployee = new Employee(fName, lName, email);
        entityManager.persist(newEmployee);
        return newEmployee;
    }

    @Override
    @Transactional
    public Employee updateEmployeeEmail(int id, String email) {
        var employee = entityManager.find(Employee.class, id);

        employee.setEmail(email);
        entityManager.merge(employee);
        return employee;
    }
}
