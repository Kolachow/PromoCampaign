package pl.mkolasinski.promocampaign.employee.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAll();

    boolean existsByEmail(String email);

    Employee findByEmail(String email);
}
