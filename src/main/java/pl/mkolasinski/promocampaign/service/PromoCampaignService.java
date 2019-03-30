package pl.mkolasinski.promocampaign.service;

import org.springframework.stereotype.Service;
import pl.mkolasinski.promocampaign.model.Campaign;

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
}
