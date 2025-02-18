package tech.majaliwa.EmployeeCRUD.services;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
