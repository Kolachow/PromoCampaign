package pl.mkolasinski.promocampaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mkolasinski.promocampaign.model.Campaign;
import pl.mkolasinski.promocampaign.service.PromoCampaignService;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class PromoCampaignController {

    private PromoCampaignService service;

    @Autowired      //niewymagane, ale wygodne, bo od razu widać wstrzykiwanie
    public PromoCampaignController(PromoCampaignService service) {
        this.service = Objects.requireNonNull(service, "Promo Campaign Service must be defined!");
    }

    @PostMapping("/campaigns")
    public ResponseEntity save(@Valid @RequestBody Campaign campaign) {
        service.save(campaign);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<Campaign>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/campaigns/current/{brand}")
    public ResponseEntity<List<Campaign>> getCurrentByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getCurrentByBrand(brand));
    }
}