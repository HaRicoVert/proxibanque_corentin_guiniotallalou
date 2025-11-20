package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.AdvisorDTO;
import fr.corentin_guiniotallalou.model.Advisor;
import fr.corentin_guiniotallalou.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvisorMapper {

    public AdvisorDTO toDTO(Advisor advisor) {
        if (advisor == null) return null;

        String agencyId = null;
        if (advisor.getAgency() != null) agencyId = advisor.getAgency().getId();

        List<Long> clientIds = null;
        if (advisor.getClients() != null)
            clientIds = advisor.getClients().stream().map(Client::getId).collect(Collectors.toList());

        return new AdvisorDTO(advisor.getId(), advisor.getLastName(), advisor.getFirstName(), agencyId, clientIds);
    }

    public Advisor toEntity(AdvisorDTO dto) {
        if (dto == null) return null;
        return new Advisor(dto.getId(), dto.getLastName(), dto.getFirstName(), null, null);
    }
}