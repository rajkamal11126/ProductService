package dev.rajkamal.productservicenov24;

import dev.rajkamal.productservicenov24.Projections.ProductProjection;
import dev.rajkamal.productservicenov24.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceNov24ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries() {
//        List<Product> products = productRepository.findByCategoryTitle("electronics");
//        System.out.println(products);

//        List<Product> products1 = productRepository.getTitleAndIdOfAllProductsWithGivenCategoryName("xyz");
//        System.out.println(products1);

        List<ProductProjection> productProjections = productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryName("electronics");

        for(ProductProjection productProjection: productProjections){
            System.out.println(productProjection.getId());
            System.out.println(productProjection.getTitle());
        }
        System.out.println();
    }
}
