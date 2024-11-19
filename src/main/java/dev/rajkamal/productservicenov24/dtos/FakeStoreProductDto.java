package dev.rajkamal.productservicenov24.dtos;


import dev.rajkamal.productservicenov24.models.Category;
import dev.rajkamal.productservicenov24.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

 public Product toProduct() {
     Product product = new Product();
     product.setTitle(title);
     product.setPrice(price);
     product.setDescription(description);

     Category category1 = new Category();
     category1.setTitle(category);

//     product.setCategory(category1);
     product.setImageUrl(image);

     return product;
 }
}
