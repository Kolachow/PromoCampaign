package pl.mkolasinski.promocampaign.campaign.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Length(min = 2, message = "Campaign name is too short. Use minimum 3 signs.")
    private String title;

    @Length(min = 2, message = "Brand name is too short. Use minimum 3 signs.")
    private String brand;

    private String description;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate endDate;

    private int employeeId;

    public Campaign() {
    }
}
