package kg.megacom.storeservice.controllers;

import kg.megacom.storeservice.models.dtos.TransactionProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/transactionProducts")
public class TransactionProductController implements BaseCrudController<TransactionProductDto, Long>{
    @Override
    public TransactionProductDto save(TransactionProductDto transactionProductDto) {
        return null;
    }

    @Override
    public TransactionProductDto update(TransactionProductDto transactionProductDto) {
        return null;
    }

    @Override
    public TransactionProductDto findById(Long id) {
        return null;
    }

    @Override
    public List<TransactionProductDto> findAll() {
        return null;
    }
}
