package dev.extore.ExtoreProduct.service.manager;

import dev.extore.ExtoreProduct.model.Category;
import dev.extore.ExtoreProduct.model.Product;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public List<Product> getSingleCategory(String categoryName);
}
