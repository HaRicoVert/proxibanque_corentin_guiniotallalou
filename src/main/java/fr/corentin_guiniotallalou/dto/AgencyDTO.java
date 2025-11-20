package fr.corentin_guiniotallalou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgencyDTO {
    private String id;
    private LocalDate creationDate;
    private ManagerDTO manager;
    private List<Long> advisorIds;
}