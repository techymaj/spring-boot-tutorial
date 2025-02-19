package tech.majaliwa.EmployeeCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.majaliwa.EmployeeCRUD.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
