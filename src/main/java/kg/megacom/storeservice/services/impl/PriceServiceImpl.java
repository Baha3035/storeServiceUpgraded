package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.PriceRepo;
import kg.megacom.storeservice.mappers.PriceMapper;
import kg.megacom.storeservice.models.dtos.PriceDto;
import kg.megacom.storeservice.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {
    private PriceRepo priceRepo;
    @Override
    public PriceDto save(PriceDto priceDto) {
        return null;
    }

    @Override
    public PriceDto update(PriceDto priceDto) {
        return null;
    }

    @Override
    public PriceDto findById(Long id) {
        return null;
    }

    @Override
    public List<PriceDto> findAll() {
        return null;
    }

    @Override
    public PriceDto findPriceByProductIdAndCurrentPriceBetweenSysdate(Long id) {
        return PriceMapper.INSTANCE.toDto(priceRepo.findPriceByProductIdAndCurrentPriceBetweenSysdate(id));
    }
}
