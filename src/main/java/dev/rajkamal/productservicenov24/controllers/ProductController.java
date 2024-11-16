package dev.rajkamal.productservicenov24.controllers;


import dev.rajkamal.productservicenov24.dtos.CreateProductRequestDto;
import dev.rajkamal.productservicenov24.models.Product;
import dev.rajkamal.productservicenov24.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    /*
    at the end of the day
    api = method in my controller
     */
    /*
    GET /products
     */
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    /*
     GET /products/{id}
     */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

        /*
        Create a product
        {
            title:
            description:
            price:
            category:
         } => payload / request body
        POST /products/{id}
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory());
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody CreateProductRequestDto requestDto, @PathVariable long id){
        return productService.updateProduct(id,
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getImage(),
                requestDto.getCategory());
    }
}
