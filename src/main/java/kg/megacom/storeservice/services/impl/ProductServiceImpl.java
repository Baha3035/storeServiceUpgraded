package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.ProductRepo;
import kg.megacom.storeservice.mappers.ProductMapper;
import kg.megacom.storeservice.models.dtos.ProductDto;
import kg.megacom.storeservice.models.dtos.TransactionDto;
import kg.megacom.storeservice.models.entities.Product;
import kg.megacom.storeservice.services.CategoryService;
import kg.megacom.storeservice.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    private CategoryService categoryService;
    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setCategory(categoryService.findById(productDto.getCategory().getId()));
        return ProductMapper.INSTANCE.toDto(productRepo.save(ProductMapper.INSTANCE.toEntity(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto findById(Long id) {
        return ProductMapper.INSTANCE.toDto(productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found!!!")));
    }

    @Override
    public List<ProductDto> findAll() {
        return ProductMapper.INSTANCE.toDtos(productRepo.findAll());
    }

}
