package pl.mkolasinski.promocampaign.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
        return ResponseEntity.ok(service.save(employee));
    }

}
