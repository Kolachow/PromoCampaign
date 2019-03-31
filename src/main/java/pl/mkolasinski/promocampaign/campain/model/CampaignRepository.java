package pl.mkolasinski.promocampaign.campain.model;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Integer> {
    List<Campaign> findAll();
    List<Campaign> findCampaignsByBrandAndStartDateBeforeAndEndDateAfter(String brand, LocalDate beforeDate, LocalDate afterDate);
    List<Campaign> findCampaignsByBrandAndStartDateAfter(String brand, LocalDate futureDate);
    List<Campaign> findCampaignsByBrandAndEndDateBefore(String brand, LocalDate beforeDate);
}
