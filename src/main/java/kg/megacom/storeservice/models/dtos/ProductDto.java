package kg.megacom.storeservice.models.dtos;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private CategoryDto category;
}
