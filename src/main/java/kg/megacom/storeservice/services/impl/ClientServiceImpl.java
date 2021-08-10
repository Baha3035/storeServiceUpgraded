package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.ClientRepo;
import kg.megacom.storeservice.mappers.ClientMapper;
import kg.megacom.storeservice.models.dtos.ClientDto;
import kg.megacom.storeservice.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    ClientRepo clientRepo;
    @Override
    public ClientDto save(ClientDto clientDto) {
        return ClientMapper.INSTANCE.toDto(clientRepo.save(ClientMapper.INSTANCE.toEntity(clientDto)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return null;
    }

    @Override
    public ClientDto findById(Long id) {
        return ClientMapper.INSTANCE.toDto(clientRepo.findById(id).orElseThrow(()-> new RuntimeException("Client not found!!!")));
    }

    @Override
    public List<ClientDto> findAll() {
        return ClientMapper.INSTANCE.toDtos(clientRepo.findAll());
    }
}
