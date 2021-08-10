package kg.megacom.storeservice.mappers;

import kg.megacom.storeservice.models.dtos.TransactionDto;
import kg.megacom.storeservice.models.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    default Transaction toEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setClient(ClientMapper.INSTANCE.toEntity(dto.getClientDto()));
        transaction.setTotalPrice(dto.getTotalPrice());
        transaction.setStatus(dto.getStatus());
        transaction.setStartDate(dto.getStartDate());
        transaction.setEndDate(dto.getEndDate());
        transaction.set
        return transaction;
    }

    default TransactionDto toDto(Transaction entity) {
        TransactionDto transaction = new TransactionDto();
        transaction.setId(entity.getId());
        transaction.setClientDto(ClientMapper.INSTANCE.toDto(entity.getClient()));
        transaction.setTotalPrice(entity.getTotalPrice());
        transaction.setStatus(entity.getStatus());
        transaction.setStartDate(entity.getStartDate());
        transaction.setEndDate(entity.getEndDate());
        return transaction;
    }

    List<Transaction> toEntities(List<TransactionDto> dtos);

    default List<TransactionDto> toDtos(List<Transaction> entities) {
        return entities.stream().map(x->{
            TransactionDto transaction = new TransactionDto();
            transaction.setId(x.getId());
            transaction.setClientDto(ClientMapper.INSTANCE.toDto(x.getClient()));
            transaction.setTotalPrice(x.getTotalPrice());
            transaction.setStatus(x.getStatus());
            transaction.setStartDate(x.getStartDate());
            transaction.setEndDate(x.getEndDate());
            return transaction;
        }).collect(Collectors.toList());
    }
}
