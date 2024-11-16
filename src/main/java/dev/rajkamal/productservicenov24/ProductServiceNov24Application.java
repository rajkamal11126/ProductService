package dev.rajkamal.productservicenov24;

import dev.rajkamal.productservicenov24.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceNov24Application {

    public static void main(String[] args) {
        Product p1 = new Product();

        SpringApplication.run(ProductServiceNov24Application.class, args);
    }

}
