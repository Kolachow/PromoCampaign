package pl.mkolasinski.promocampaign.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.mkolasinski.promocampaign.employee.model.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Employee> employees;

    public Role() {
    }
}
