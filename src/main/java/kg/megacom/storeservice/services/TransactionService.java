package kg.megacom.storeservice.services;

import kg.megacom.storeservice.models.dtos.TransactionDto;

import kg.megacom.storeservice.models.dtos.customDtos.responses.*;
import kg.megacom.storeservice.models.dtos.customDtos.inputs.*;
import java.util.List;

public interface TransactionService extends BaseCrudService<TransactionDto, Long>{
    double priceCounter(int count, double price);
    TransactionResponse doTransaction(List<ProductCountInput> productsList, Long id);
    TransactionResponseWithDebt pay(Long transaction_id, double money);
}
