package dev.rajkamal.productservicenov24.controllers;


import dev.rajkamal.productservicenov24.dtos.CreateProductRequestDto;
import dev.rajkamal.productservicenov24.models.Product;
import dev.rajkamal.productservicenov24.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Controller
public class ProductController {

    private final RestTemplate restTemplate;
    public ProductService productService;

    public ProductController(ProductService productService, RestTemplate restTemplate){
        this.productService = productService;
        this.restTemplate = restTemplate;
    }
    /*
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id){
        Product p = productService.getSingleProduct(id);

        ResponseEntity<Product> responseEntity;
                if(p == null){
                    responseEntity = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
                }else{
                    responseEntity = new ResponseEntity<>(p, HttpStatus.OK);
                }



        return responseEntity;
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
