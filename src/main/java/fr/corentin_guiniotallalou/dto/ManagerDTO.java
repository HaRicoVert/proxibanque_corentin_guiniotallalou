package fr.corentin_guiniotallalou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    private Long id;
    private String lastName;
    private String firstName;
}