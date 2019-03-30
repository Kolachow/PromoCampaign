package pl.mkolasinski.promocampaign.employee.service;

import org.springframework.stereotype.Service;
import pl.mkolasinski.promocampaign.employee.model.Employee;
import pl.mkolasinski.promocampaign.employee.model.EmployeeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Customer Service must be defined!");
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    public List<Employee> getEmployeeList() {
        return repository.findAll();
    }
}
