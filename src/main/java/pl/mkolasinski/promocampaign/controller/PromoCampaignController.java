package pl.mkolasinski.promocampaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mkolasinski.promocampaign.model.Campaign;
import pl.mkolasinski.promocampaign.service.PromoCampaignService;

import javax.validation.Valid;
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
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}