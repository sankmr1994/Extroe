package dev.extore.ExtoreProduct.controller;

import dev.extore.ExtoreProduct.dto.FakeStoreProductDto;
import dev.extore.ExtoreProduct.dto.requestDto.CreateProductRequest;
import dev.extore.ExtoreProduct.model.Category;
import dev.extore.ExtoreProduct.model.Product;
import dev.extore.ExtoreProduct.service.manager.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Integer productId) {
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return productService.createProduct(createProductRequest.getTitle(), createProductRequest.getPrice(), createProductRequest.getCategory(), createProductRequest.getDescription(), createProductRequest.getImage());
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Integer productId) {
        productService.updateProduct(productId);
    }


    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Integer productId) {
        productService.deleteProduct(productId);
    }

}
