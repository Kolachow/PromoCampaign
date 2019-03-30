package pl.mkolasinski.promocampaign.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
public class Campaign {

    @Length(min = 3, message = "Campaign name is too short. Use minimum 3 signs.")
    private String title;

    @Length(min = 3, message = "Brand name is too short. Use minimum 3 signs.")
    private String brand;

    private String description;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate endDate;
}
