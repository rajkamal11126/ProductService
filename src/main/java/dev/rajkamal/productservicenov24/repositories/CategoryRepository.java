package dev.rajkamal.productservicenov24.repositories;


import dev.rajkamal.productservicenov24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);  // JPA method

    Optional<Category> findById(Long id);

    /*
    Select * from Category
    where title like 'title'

    convert the row to category object and return
     */
}
