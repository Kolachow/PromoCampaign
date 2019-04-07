package pl.mkolasinski.promocampaign.campaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mkolasinski.promocampaign.campaign.model.Campaign;
import pl.mkolasinski.promocampaign.campaign.service.PromoCampaignService;
import pl.mkolasinski.promocampaign.employee.model.Employee;
import pl.mkolasinski.promocampaign.employee.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PromoCampaignController {

    private PromoCampaignService service;
    private EmployeeService employeeService;

    @Autowired      //niewymagane, ale wygodne, bo od razu widać wstrzykiwanie
    public PromoCampaignController(PromoCampaignService service,
                                   EmployeeService employeeService) {
        this.service = Objects.requireNonNull(service, "Promo Campaign Service must be defined!");
        this.employeeService = Objects.requireNonNull(employeeService, "Employee Service must be defined!");
    }

    @PostMapping("/campaigns")
    public ResponseEntity save(@Valid @RequestBody Campaign campaign) {
        Optional<Employee> employee = employeeService.getEmployeeById(campaign.getEmployeeId());

        if (employee.isPresent()) {
            if (employee.get().getCompany().equals(campaign.getBrand())) {
                service.save(campaign);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().body("Invalid employee brand.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid employee id.");
        }
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<Campaign>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/campaigns/all/{brand}")
    public ResponseEntity<List<Campaign>> getAllByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getAllByBrand(brand));
    }

    @GetMapping("/campaigns/current/{brand}")
    public ResponseEntity<List<Campaign>> getCurrentByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getCurrentByBrand(brand));
    }

    @GetMapping("/campaigns/future/{brand}")
    public ResponseEntity<List<Campaign>> getFutureByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getFutureByBrand(brand));
    }

    @GetMapping("/campaigns/ended/{brand}")
    public ResponseEntity<List<Campaign>> getEndedByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getEndedByBrand(brand));
    }
}