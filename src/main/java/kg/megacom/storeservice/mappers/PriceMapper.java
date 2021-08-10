package kg.megacom.storeservice.mappers;

import kg.megacom.storeservice.models.dtos.PriceDto;
import kg.megacom.storeservice.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price toEntity(PriceDto dto);
    PriceDto toDto(Price entity);


}
