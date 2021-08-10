package kg.megacom.storeservice.services;

import kg.megacom.storeservice.models.dtos.PriceDto;
import kg.megacom.storeservice.models.entities.Price;

public interface PriceService extends BaseCrudService<PriceDto, Long>{
    PriceDto findPriceByProductIdAndCurrentPriceBetweenSysdate(Long id);
}
