package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.TransactionHistoryRepo;
import kg.megacom.storeservice.models.dtos.TransactionHistoryDto;
import kg.megacom.storeservice.services.TransactionHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
    private TransactionHistoryRepo transactionHistoryRepo;
    @Override
    public TransactionHistoryDto save(TransactionHistoryDto transactionHistoryDto) {
        return null;
    }

    @Override
    public TransactionHistoryDto update(TransactionHistoryDto transactionHistoryDto) {
        return null;
    }

    @Override
    public TransactionHistoryDto findById(Long id) {
        return null;
    }

    @Override
    public List<TransactionHistoryDto> findAll() {
        return null;
    }
}
