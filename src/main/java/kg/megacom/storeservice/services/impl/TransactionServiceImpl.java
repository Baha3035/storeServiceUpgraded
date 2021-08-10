package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.TransactionRepo;
import kg.megacom.storeservice.exceptions.AlreadyPaidException;
import kg.megacom.storeservice.mappers.TransactionMapper;
import kg.megacom.storeservice.models.dtos.TransactionDto;
import kg.megacom.storeservice.models.dtos.TransactionHistoryDto;
import kg.megacom.storeservice.models.dtos.TransactionProductDto;
import kg.megacom.storeservice.models.enums.Status;
import kg.megacom.storeservice.services.*;
import kg.megacom.storeservice.models.dtos.customDtos.responses.*;
import kg.megacom.storeservice.models.dtos.customDtos.responses.TransactionResponseWithDebt;
import kg.megacom.storeservice.models.dtos.customDtos.inputs.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    ProductService productService;

    TransactionRepo transactionRepo;

    TransactionProductService transactionProductService;

    ClientService clientService;

    PriceService priceService;

    TransactionHistoryService transactionHistoryService;

    @Override
    public TransactionDto save(TransactionDto dto) {
//        dto.setClientDto(clientService.findById(dto.getClientDto().getId()));
        return TransactionMapper.INSTANCE.toDto(transactionRepo.save(TransactionMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public TransactionDto update(TransactionDto dto) {
        return null;
    }

    @Override
    public TransactionDto findById(Long id) {
        return TransactionMapper.INSTANCE.toDto(transactionRepo.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found!!!")));
    }

    @Override
    public List<TransactionDto> findAll() {
        return TransactionMapper.INSTANCE.toDtos(transactionRepo.findAll());
    }

    @Override
    public TransactionResponse doTransaction(List<ProductCountInput> productsList, Long id){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setStatus(Status.NOT_PAID);
        transactionDto.setClientDto(clientService.findById(id));
        List<TransactionProductDto> transactionProductDtos = productsList.stream().map(x -> {
            TransactionProductDto transactionProductDto = new TransactionProductDto();
            transactionProductDto.setProduct(productService.findById(x.getProductId()));
            transactionProductDto.setProductCount(x.getCount());
            transactionProductDto.setPrice(priceCounter(x.getCount(), priceService.findPriceByProductIdAndCurrentPriceBetweenSysdate(x.getProductId()).getPrice()));
            return transactionProductDto;
        }).collect(Collectors.toList());


        transactionDto.setTotalPrice(transactionProductDtos.stream().mapToDouble(TransactionProductDto::getPrice).sum());
        TransactionDto transactionDtoSaved = save(transactionDto);

        List<TransactionProductDto> transactionProductDtosSaved = transactionProductDtos.stream().map(w -> {
            w.setTransaction(transactionDtoSaved);
            return transactionProductService.save(w);
        }).collect(Collectors.toList());



        TransactionResponse transactionResponse = new TransactionResponse();
        List<ProductCountOutput> productCountOutputs = transactionProductDtosSaved.stream().map(x -> {
            ProductCountOutput productCountOutput = new ProductCountOutput();
            productCountOutput.setCount(x.getProductCount());
            productCountOutput.setPrice(x.getPrice());
            productCountOutput.setName(x.getProduct().getName());
            return productCountOutput;
        }).collect(Collectors.toList());
        transactionResponse.setProducts(productCountOutputs);
        transactionResponse.setStatus(transactionDtoSaved.getStatus());
        transactionResponse.setTotalPrice(transactionDtoSaved.getTotalPrice());
        return transactionResponse;
    }
    @Override
    public double priceCounter(int count, double price){
        return count * price;
    }

    @Override
    public TransactionResponseWithDebt pay(Long transaction_id, double money){

        TransactionDto transactionDto = findById(transaction_id);
        if(transactionDto.getStatus()==Status.NOT_PAID) {

            TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();

            transactionHistoryDto.setMoneyPaid(transactionHistoryDto.getMoneyPaid() + money);
            if (transactionHistoryDto.getMoneyPaid() >= transactionDto.getTotalPrice()) {
                transactionHistoryDto.setExcess(transactionHistoryDto.getMoneyPaid() - transactionDto.getTotalPrice());
                transactionHistoryDto.setDebt(0);
                transactionDto.setStatus(Status.SUCCESS);
            } else {
                transactionHistoryDto.setDebt(transactionHistoryDto.getMoneyPaid() - transactionDto.getTotalPrice());
            }

            TransactionDto transactionDtoSaved = save(transactionDto);
            transactionHistoryDto.setTransaction(transactionDtoSaved);
            TransactionHistoryDto transactionHistoryDtoSaved = transactionHistoryService.save(transactionHistoryDto);

            TransactionResponseWithDebt transactionResponseWithDebt = new TransactionResponseWithDebt();
            transactionResponseWithDebt.setDebt(transactionHistoryDtoSaved.getDebt());
            transactionResponseWithDebt.setStatus(transactionDtoSaved.getStatus());
            transactionResponseWithDebt.setPaidAmount(transactionHistoryDtoSaved.getMoneyPaid());
            transactionResponseWithDebt.setTotalPrice(transactionDtoSaved.getTotalPrice());
            transactionResponseWithDebt.setExcessMoney(transactionHistoryDtoSaved.getExcess());

            return transactionResponseWithDebt;
        }
        throw  new AlreadyPaidException("Уже оплачено!!!");
    }
}
