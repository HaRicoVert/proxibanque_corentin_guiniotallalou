package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.dto.ClientDTO;
import fr.corentin_guiniotallalou.service.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-accounts")
    public ResponseEntity<ClientDTO> getClientWithAccounts(@PathVariable Long id) {
        return clientService.findByIdWithAccounts(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.save(clientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return clientService.findById(id)
                .map(existing -> {
                    clientDTO.setId(id);
                    return ResponseEntity.ok(clientService.save(clientDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}