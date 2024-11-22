package dev.rajkamal.productservicenov24.repositories;

import dev.rajkamal.productservicenov24.models.Category;
import dev.rajkamal.productservicenov24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {
    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);

    List<Product> findByCategory(Category category);
    List<Product> findByCategoryTitle(String categoryTitle);
    List<Product> findByTitleStartingWithAndEndingWith(String categoryStartWith);




}
