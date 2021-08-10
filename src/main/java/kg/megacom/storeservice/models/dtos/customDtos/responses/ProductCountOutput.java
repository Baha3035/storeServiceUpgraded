package kg.megacom.storeservice.models.dtos.customDtos.responses;

import lombok.Data;

@Data
public class ProductCountOutput {
    private String name;
    private int count;
    private double price;
}
