package kg.megacom.storeservice.controllers;

import kg.megacom.storeservice.models.dtos.ClientDto;
import kg.megacom.storeservice.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/clients")
@AllArgsConstructor
public class ClientController implements BaseCrudController<ClientDto, Long>{
    private ClientService clientService;
    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return null;
    }

    @Override
    public ClientDto findById(Long id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }
}
