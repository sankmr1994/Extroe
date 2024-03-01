package dev.extore.ExtoreProduct.service.impl;

import dev.extore.ExtoreProduct.dto.FakeStoreCategoryDto;
import dev.extore.ExtoreProduct.dto.FakeStoreProductDto;
import dev.extore.ExtoreProduct.model.Category;
import dev.extore.ExtoreProduct.model.Product;
import dev.extore.ExtoreProduct.service.manager.CategoryService;
import dev.extore.ExtoreProduct.utils.CategoryUtils;
import dev.extore.ExtoreProduct.utils.CommonUtils;
import dev.extore.ExtoreProduct.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Category> getAllCategories() {
        ResponseEntity<FakeStoreCategoryDto[]> fakeStoreCatergoryList = restTemplate.getForEntity(CategoryUtils.BASE_URL, FakeStoreCategoryDto[].class);
        FakeStoreCategoryDto[] fakeStoreCategorys = fakeStoreCatergoryList.getBody();
        List<Category> categories = new ArrayList<>();
        if (fakeStoreCategorys != null) {
            for (FakeStoreCategoryDto fakeStoreCategoryDto : fakeStoreCategorys) {
                categories.add(fakeStoreCategoryDto.categoryMapper());
            }
        }
        return categories;
    }

    @Override
    public List<Product> getSingleCategory(String categoryName) {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductList = restTemplate.getForEntity(ProductUtils.BASE_URL + CommonUtils.URL_SLASH + "category" + CommonUtils.URL_SLASH +categoryName, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProducts = fakeStoreProductList.getBody();
        List<Product> products = new ArrayList<>();
        if (fakeStoreProducts != null) {
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProducts) {
                products.add(fakeStoreProductDto.productMapper());
            }
        }
        return products;
    }
}
