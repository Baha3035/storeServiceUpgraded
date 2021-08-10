package kg.megacom.storeservice.controllers;

import kg.megacom.storeservice.models.dtos.CategoryDto;
import kg.megacom.storeservice.models.entities.Category;
import kg.megacom.storeservice.models.entities.Product;
import kg.megacom.storeservice.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController implements BaseCrudController<CategoryDto, Long>{
    private CategoryService categoryService;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }
}
