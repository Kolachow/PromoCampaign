package pl.mkolasinski.promocampaign.employee.service;

import org.springframework.stereotype.Service;
import pl.mkolasinski.promocampaign.employee.model.Employee;
import pl.mkolasinski.promocampaign.employee.model.EmployeeRepository;
import pl.mkolasinski.promocampaign.roles.Role;
import pl.mkolasinski.promocampaign.roles.model.RoleRepository;

import java.util.*;

@Service
public class EmployeeService {

    private EmployeeRepository repository;
    private RoleRepository roleRepository;

    public EmployeeService(EmployeeRepository repository, RoleRepository roleRepository) {
        this.repository = Objects.requireNonNull(repository, "Customer Service must be defined!");
        this.roleRepository = Objects.requireNonNull(roleRepository, "Role must be defined!");
    }

    public Employee save(Employee employee) {
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        role.ifPresent(roleUser -> employee.setRoles(new HashSet<>(Arrays.asList(roleUser))));
        return repository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    public List<Employee> getEmployeeList() {
        return repository.findAll();
    }

    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public Employee getCustomerByEmail(String email) {
        return repository.findByEmail(email);
    }
}
