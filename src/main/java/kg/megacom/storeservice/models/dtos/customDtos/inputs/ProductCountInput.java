package kg.megacom.storeservice.models.dtos.customDtos.inputs;

import lombok.Data;

@Data
public class ProductCountInput {
    private Long productId;
    private int count;
}
