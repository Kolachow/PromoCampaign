package pl.mkolasinski.promocampaign.campain.service;

import org.springframework.stereotype.Service;
import pl.mkolasinski.promocampaign.campain.model.Campaign;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromoCampaignService {

    private List<Campaign> campaigns = new ArrayList<>();

    public void save(Campaign campaign) {
        campaigns.add(campaign);
    }

    public List<Campaign> getAll() {
        return campaigns;
    }

    public List<Campaign> getCurrentByBrand(String brand) {
        return campaigns.stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getStartDate().isBefore(LocalDate.now()))
                .filter(campaign -> campaign.getEndDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Campaign> getFutureByBrand(String brand) {
        return campaigns.stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getStartDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Campaign> getEndedByBrand(String brand) {
        return campaigns.stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getEndDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }
}
