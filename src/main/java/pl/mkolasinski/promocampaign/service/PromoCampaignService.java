package pl.mkolasinski.promocampaign.service;

import org.springframework.stereotype.Service;
import pl.mkolasinski.promocampaign.model.Campaign;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromoCampaignService {

    private List<Campaign> campaigns = new ArrayList<>();

    public void save(Campaign campaign) {
        campaigns.add(campaign);
    }

    public List<Campaign> getAll() {
        return campaigns;
    }
}
