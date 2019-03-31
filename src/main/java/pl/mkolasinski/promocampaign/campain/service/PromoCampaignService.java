package pl.mkolasinski.promocampaign.campain.service;

import org.springframework.stereotype.Service;
import pl.mkolasinski.promocampaign.campain.model.Campaign;
import pl.mkolasinski.promocampaign.campain.model.CampaignRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PromoCampaignService {

    private CampaignRepository repository;

    public PromoCampaignService(CampaignRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Campaign Service must be defined!");
    }

    public void save(Campaign campaign) {
        repository.save(campaign);
    }

    public List<Campaign> getAll() {
        return repository.findAll();
    }

    public List<Campaign> getCurrentByBrand(String brand) {
        return repository.findCampaignsByBrandAndStartDateBeforeAndEndDateAfter(brand, LocalDate.now(), LocalDate.now());
    }

    public List<Campaign> getFutureByBrand(String brand) {
        return repository.findCampaignsByBrandAndStartDateAfter(brand, LocalDate.now());
    }

    public List<Campaign> getEndedByBrand(String brand) {
        return repository.findCampaignsByBrandAndEndDateBefore(brand, LocalDate.now());
    }
}
