package pl.mkolasinski.promocampaign.employee.model;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Employee {

    @NotNull
    private String firstName;
    @NonNull
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String company;

    @Email
    private String email;
    @Length(min = 5, message = "Use more than 4 characters!")
    private String password;

    public Employee() {
    }
}
