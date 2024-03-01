package dev.extore.ExtoreProduct.service.manager;

import dev.extore.ExtoreProduct.model.Product;
import dev.extore.ExtoreProduct.utils.ProductUtils;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(Integer productId);

    public List<Product> getAllProduct();

    public Product createProduct(String title,Double price,String category,String description,String image);

    public void updateProduct(Integer productId);

    public void deleteProduct(Integer productId);
}
