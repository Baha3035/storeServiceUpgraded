package kg.megacom.storeservice.models.dtos;

import lombok.Data;

@Data
public class TransactionProductDto {
    private Long id;
    private TransactionDto transaction;
    private ProductDto product;
    private double price;
    private int productCount;
}
