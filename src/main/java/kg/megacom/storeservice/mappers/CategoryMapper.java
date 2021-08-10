package kg.megacom.storeservice.mappers;

import kg.megacom.storeservice.models.dtos.CategoryDto;
import kg.megacom.storeservice.models.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    default Category toEntity(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    default CategoryDto toDto(Category entity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());
        return categoryDto;
    }

    List<Category> toEntities(List<CategoryDto> dtos);

    default List<CategoryDto> toDtos(List<Category> entities) {
        return entities.stream().map(x->{
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(x.getId());
            categoryDto.setName(x.getName());
            return categoryDto;
        }).collect(Collectors.toList());
    }
}
