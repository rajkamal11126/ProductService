package dev.rajkamal.productservicenov24.services;

import dev.rajkamal.productservicenov24.configs.RestTemplateConfig;
import dev.rajkamal.productservicenov24.dtos.FakeStoreProductDto;
import dev.rajkamal.productservicenov24.exceptions.ProductNotFoundException;
import dev.rajkamal.productservicenov24.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplateConfig restTemplateConfig;
    private RestTemplate restTemplate; //using this, you will be able to call 3rd party api
    public FakeStoreProductService(RestTemplate restTemplate, RestTemplateConfig restTemplateConfig) {
        this.restTemplate = restTemplate;
        this.restTemplateConfig = restTemplateConfig;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            Product p = fakeStoreProductDto.toProduct();
            products.add(p);
        }
        return products;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        /*
        call the external fakestore product api
        'https://fakestoreapi.com/products/1'
         */
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
//                FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);

        if(fakeStoreProductDtoResponseEntity.getStatusCode() != HttpStatus.OK) {
            //handle this exception
        }
//        fakeStoreProductDtoResponseEntity.getHeaders();
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with "+id+" is not present with the service. It's an invalid id");
        }

        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class);

        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product updateProduct(long id, String title, String description, int price, String image, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setCategory(category);

        restTemplate.put("https://fakestoreapi.com/products/" + id, fakeStoreProductDto);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<String> getAllCategories() {
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
        return Arrays.stream(fakeStoreProductDtos)
                .map(FakeStoreProductDto::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }
}
