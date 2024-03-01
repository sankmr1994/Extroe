package dev.extore.ExtoreProduct.controller;

import dev.extore.ExtoreProduct.model.Category;
import dev.extore.ExtoreProduct.model.Product;
import dev.extore.ExtoreProduct.service.impl.FakeStoreCategoryServiceImpl;
import dev.extore.ExtoreProduct.service.manager.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private FakeStoreCategoryServiceImpl categoryService;

    @GetMapping("/products/categories")
    public List<Category> geCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/products/categories/{name}")
    public List<Product> getCategoryDetails(@PathVariable("name") String categoryName) {
        return categoryService.getSingleCategory(categoryName);
    }
}
