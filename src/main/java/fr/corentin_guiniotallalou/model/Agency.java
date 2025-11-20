package fr.corentin_guiniotallalou.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agency {
    @Id
    @Column(length = 5)
    private String id;

    private LocalDate creationDate;

    @OneToOne
    private Manager manager;

    @OneToMany(mappedBy = "agency")
    private List<Advisor> advisors = new ArrayList<>();

    @Override
    public String toString() {
        return "Agency{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", manager=" + manager +
                ", advisors=" + advisors +
                '}';
    }
}