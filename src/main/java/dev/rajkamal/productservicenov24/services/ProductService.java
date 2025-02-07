package dev.rajkamal.productservicenov24.services;

import dev.rajkamal.productservicenov24.exceptions.ProductNotFoundException;
import dev.rajkamal.productservicenov24.models.Product;
import java.util.List;

public interface ProductService{
    List<Product> getAllProducts();
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product createProduct(String title,
                          String description,
                          double price,
                          String imageUrl,
                          String category);

    Product updateProduct(long id,
                          String title,
                          String description,
                          int price,
                          String image,
                          String category);
    List<String> getAllCategories();
}
