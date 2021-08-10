package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.TransactionsProductsRepo;
import kg.megacom.storeservice.mappers.TransactionMapper;
import kg.megacom.storeservice.mappers.TransactionProductMapper;
import kg.megacom.storeservice.models.dtos.TransactionProductDto;
import kg.megacom.storeservice.models.entities.TransactionProduct;
import kg.megacom.storeservice.services.TransactionProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TransactionProductSeviceImpl implements TransactionProductService {

    TransactionsProductsRepo transactionsProductsRepo;
    @Override
    public TransactionProductDto save(TransactionProductDto transactionProductDto) {
        return TransactionProductMapper.INSTANCE.toDto(transactionsProductsRepo.save(TransactionProductMapper.INSTANCE.toEntity(transactionProductDto)));
    }

    @Override
    public TransactionProductDto update(TransactionProductDto transactionProductDto) {
        return null;
    }

    @Override
    public TransactionProductDto findById(Long id) {
        return TransactionProductMapper.INSTANCE.toDto(transactionsProductsRepo.findById(id).orElseThrow(()-> new RuntimeException("TransactionProduct not found!!!")));
    }

    @Override
    public List<TransactionProductDto> findAll() {
        return TransactionProductMapper.INSTANCE.toDtos(transactionsProductsRepo.findAll());
    }
}
