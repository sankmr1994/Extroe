package dev.extore.ExtoreProduct.service.impl;

import dev.extore.ExtoreProduct.dto.FakeStoreProductDto;
import dev.extore.ExtoreProduct.model.Product;
import dev.extore.ExtoreProduct.service.manager.ProductService;
import dev.extore.ExtoreProduct.utils.CommonUtils;
import dev.extore.ExtoreProduct.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getSingleProduct(Integer productId) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(ProductUtils.BASE_URL + CommonUtils.URL_SLASH + productId, FakeStoreProductDto.class);
        if (fakeStoreProductDto != null) {
            return fakeStoreProductDto.productMapper();
        } else {
            return new Product();
        }
    }

    @Override
    public List<Product> getAllProduct() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductList = restTemplate.getForEntity(ProductUtils.BASE_URL, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProducts = fakeStoreProductList.getBody();
        List<Product> products = new ArrayList<>();
        if (fakeStoreProducts != null) {
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProducts) {
                products.add(fakeStoreProductDto.productMapper());
            }
        }
        return products;
    }

    @Override
    public Product createProduct(String title, Double price, String category, String description, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto storeProductDto = restTemplate.postForObject(ProductUtils.BASE_URL, fakeStoreProductDto, FakeStoreProductDto.class);
        if (storeProductDto != null) {
            return storeProductDto.productMapper();
        } else {
            return new Product();
        }
    }

    @Override
    public void updateProduct(Integer productId) {
        Product product = getSingleProduct(productId);
        restTemplate.put(ProductUtils.BASE_URL + CommonUtils.URL_SLASH + productId, product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        restTemplate.delete(ProductUtils.BASE_URL + CommonUtils.URL_SLASH + productId);
    }
}
