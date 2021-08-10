package kg.megacom.storeservice.models.dtos;

import lombok.Data;

@Data
public class RestDto {
    private ProductDto product;
    private int amount;
}
