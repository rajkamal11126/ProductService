package dev.rajkamal.productservicenov24.repositories;

import dev.rajkamal.productservicenov24.Projections.ProductProjection;
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
//    List<Product> findByTitleStartingWithAndCategoryEndingWith(String categoryStartWith);

    /*
    title, id of products
    HQL
     */

    @Query("select p.title as title, p.id from Product p where p.category.title = :categoryName")
    List<ProductProjection> getTitleAndIdOfAllProductsWithGivenCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "select * from products p where p.id = 3 and p.title = :productTitle", nativeQuery = true)
    List<ProductProjection> getTitleAndIdOfAllProductsWithGivenCategoryNameEquals(@Param("categoryName") String categoryName);





}
