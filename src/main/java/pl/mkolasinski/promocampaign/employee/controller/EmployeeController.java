package pl.mkolasinski.promocampaign.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mkolasinski.promocampaign.employee.model.Employee;
import pl.mkolasinski.promocampaign.employee.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = Objects.requireNonNull(service, "Employee service must be defined!");
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {
        if(service.existByEmail(employee.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(service.save(employee));
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getEmployeeList());
    }


    @GetMapping("/customers/{email}")
    public ResponseEntity<Employee> getByEmail(@PathVariable String email) {
        return ResponseEntity
                .ok(service.getCustomerByEmail(email));
    }
}
