package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.ManagerDTO;
import fr.corentin_guiniotallalou.model.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    public ManagerDTO toDTO(Manager manager) {
        if (manager == null) return null;

        return new ManagerDTO(
            manager.getId(),
            manager.getLastName(),
            manager.getFirstName()
        );
    }

    public Manager toEntity(ManagerDTO dto) {
        if (dto == null) return null;

        return new Manager(
            dto.getId(),
            dto.getLastName(),
            dto.getFirstName()
        );
    }
}
