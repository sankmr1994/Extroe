package dev.extore.ExtoreProduct.dto.requestDto;

import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String title;

    private Double price;

    private String category;

    private String description;

    private String image;
}
