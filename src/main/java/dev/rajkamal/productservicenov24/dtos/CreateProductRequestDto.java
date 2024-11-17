package dev.rajkamal.productservicenov24.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private int price;
    private String category;
    private String image;
}
