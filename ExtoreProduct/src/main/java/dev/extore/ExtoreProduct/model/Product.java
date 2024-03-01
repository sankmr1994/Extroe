package dev.extore.ExtoreProduct.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Integer id;

    private String title;

    private Double price;

    private String description;

    private Category category;

    private String image;
}
