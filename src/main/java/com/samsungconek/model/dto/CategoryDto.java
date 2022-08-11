package com.samsungconek.model.dto;

import com.samsungconek.model.entity.Brand;
import com.samsungconek.model.entity.Category;
import com.samsungconek.model.entity.Spec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;

    private String name;

    private List<Brand> brands;

    private boolean status;

    private CategoryDto parentCategoryDto;

    // private int level;

    private List<Spec> spec;

    public CategoryDto(Category category, List<CategoryDto> childCategoriesDto) {
        this.id = category.getId();
        this.name = category.getName();
        this.brands = category.getBrands();
        // this.level = category.getLevel();
        this.status = category.isStatus();
        this.spec = category.getSpecs();

        if (category.getParentCategory() != null) {
            this.parentCategoryDto = new CategoryDto(category.getParentCategory(), null);
            // truyền cho đối tượng parentCateDto 1 đối tượng parentCate
        }

//        this.childCategoriesDto = childCategoriesDto;
    }
}
