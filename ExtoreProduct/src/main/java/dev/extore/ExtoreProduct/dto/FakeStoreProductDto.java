package dev.extore.ExtoreProduct.dto;

import dev.extore.ExtoreProduct.model.Category;
import dev.extore.ExtoreProduct.model.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FakeStoreProductDto {

    private Integer id;

    private String title;

    private Double price;

    private String category;

    private String description;

    private String image;

    public Product productMapper() {
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImage(this.image);
        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);

        return product;
    }
}
