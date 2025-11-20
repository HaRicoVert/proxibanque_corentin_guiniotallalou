package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.AgencyDTO;
import fr.corentin_guiniotallalou.model.Advisor;
import fr.corentin_guiniotallalou.model.Agency;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgencyMapper {

    private final ManagerMapper managerMapper;

    public AgencyMapper(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public AgencyDTO toDTO(Agency agency) {
        if (agency == null) return null;

        List<Long> advisorIds = null;
        if (agency.getAdvisors() != null)
            advisorIds = agency.getAdvisors().stream().map(Advisor::getId).collect(Collectors.toList());

        return new AgencyDTO(agency.getId(), agency.getCreationDate(), managerMapper.toDTO(agency.getManager()), advisorIds);
    }

    public Agency toEntity(AgencyDTO dto) {
        if (dto == null) return null;
        return new Agency(dto.getId(), dto.getCreationDate(), managerMapper.toEntity(dto.getManager()), null);
    }
}
