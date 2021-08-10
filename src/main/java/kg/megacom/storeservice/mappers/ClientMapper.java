package kg.megacom.storeservice.mappers;

import kg.megacom.storeservice.models.dtos.ClientDto;
import kg.megacom.storeservice.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    default Client toEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        return client;
    }

    default ClientDto toDto(Client entity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(entity.getId());
        clientDto.setName(entity.getName());
        return clientDto;
    }

    List<Client> toEntities(List<ClientDto> dtos);

    default List<ClientDto> toDtos(List<Client> entities) {
        return entities.stream().map(x->{
            ClientDto clientDto = new ClientDto();
            clientDto.setId(x.getId());
            clientDto.setName(x.getName());
            return clientDto;
        }).collect(Collectors.toList());
    }
}
