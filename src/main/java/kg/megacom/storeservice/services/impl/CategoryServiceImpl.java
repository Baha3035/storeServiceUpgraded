package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.CategoryRepo;
import kg.megacom.storeservice.mappers.CategoryMapper;
import kg.megacom.storeservice.models.dtos.CategoryDto;
import kg.megacom.storeservice.models.dtos.TransactionDto;
import kg.megacom.storeservice.models.entities.Category;
import kg.megacom.storeservice.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    CategoryRepo categoryRepo;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return CategoryMapper.INSTANCE.toDto(categoryRepo.save(CategoryMapper.INSTANCE.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto findById(Long id) {
        return CategoryMapper.INSTANCE.toDto(categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found!!!")));
    }

    @Override
    public List<CategoryDto> findAll() {
        return CategoryMapper.INSTANCE.toDtos(categoryRepo.findAll());
    }
}
