package fr.corentin_guiniotallalou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String agencyId;
    private List<Long> clientIds;
}