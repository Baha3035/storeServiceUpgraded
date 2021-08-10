package kg.megacom.storeservice.controllers;

import kg.megacom.storeservice.models.dtos.TransactionDto;
import kg.megacom.storeservice.models.dtos.customDtos.inputs.ProductCountInput;
import kg.megacom.storeservice.models.dtos.customDtos.responses.TransactionResponse;
import kg.megacom.storeservice.models.dtos.customDtos.responses.TransactionResponseWithDebt;
import kg.megacom.storeservice.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
@AllArgsConstructor
public class TransactionController implements BaseCrudController<TransactionDto, Long>{
    private TransactionService transactionService;
    @Override
    public TransactionDto save(TransactionDto transaction) {
        return transactionService.save(transaction);
    }

    @Override
    public TransactionDto update(TransactionDto dto) {
        return null;
    }

    @Override
    public TransactionDto findById(Long id) {
        return transactionService.findById(id);
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionService.findAll();
    }

    @PostMapping("/buy-products")
    public TransactionResponse doTransaction(@RequestBody List<ProductCountInput> productsList, @RequestParam Long client_id){
        return transactionService.doTransaction(productsList, client_id);
    }

    @PostMapping("/pay-for-products")
    public TransactionResponseWithDebt pay(@RequestParam Long transaction_id, @RequestParam double money){
        return transactionService.pay(transaction_id, money);
    }
}
