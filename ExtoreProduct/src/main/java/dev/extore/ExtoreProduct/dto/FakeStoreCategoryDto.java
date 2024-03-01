package dev.extore.ExtoreProduct.dto;

import dev.extore.ExtoreProduct.model.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FakeStoreCategoryDto {
    private String name;

    public Category categoryMapper() {
        Category category = new Category();
        category.setName(this.name);
        return category;
    }
}
