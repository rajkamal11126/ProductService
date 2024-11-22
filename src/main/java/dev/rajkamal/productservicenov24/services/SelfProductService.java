package dev.rajkamal.productservicenov24.services;

import dev.rajkamal.productservicenov24.exceptions.ProductNotFoundException;
import dev.rajkamal.productservicenov24.models.Category;
import dev.rajkamal.productservicenov24.models.Product;
import dev.rajkamal.productservicenov24.repositories.CategoryRepository;
import dev.rajkamal.productservicenov24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository,
                              ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product==null) {
            throw new ProductNotFoundException("Product with id " + id + " is not found in the database");
        }
        return product.get();
    }

    @Override
    public Product createProduct(String title, String description, double price, String imageUrl, String category) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryFromDB = categoryRepository.findByTitle(category);
        if(categoryFromDB == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDB = newCategory;
        }

            product.setCategory(categoryFromDB);
            Product createdProduct = productRepository.save(product);
        return createdProduct;
    }

    @Override
    public Product updateProduct(long id, String title, String description, int price, String image, String category) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return List.of();
    }
}
