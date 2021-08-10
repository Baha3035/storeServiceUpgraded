package kg.megacom.storeservice.controllers;

import kg.megacom.storeservice.models.dtos.ProductDto;
import kg.megacom.storeservice.models.entities.Product;
import kg.megacom.storeservice.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController implements BaseCrudController<ProductDto, Long>{
    private ProductService productService;
    @Override
    public ProductDto save(ProductDto productDto) {
        return productService.save(productDto);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto findById(Long id) {
        return productService.findById(id);
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

}
