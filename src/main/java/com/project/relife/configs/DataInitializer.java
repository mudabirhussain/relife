package com.project.relife.configs;

import com.project.relife.entities.CustomerEntity;
import com.project.relife.entities.ProductEntity;
import com.project.relife.repositories.CustomerRepo;
import com.project.relife.repositories.ProductRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;

    public DataInitializer(ProductRepo productRepo, CustomerRepo customerRepo) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }

    @Bean
    @Transactional
    public ApplicationRunner initializer() {
        return args -> {
            productRepo.save(new ProductEntity(1L, "Sample Product 1", "Description for Sample Product 1", 55L, "USD", "Electronics", "https://example.com/product1.jpg"));
            productRepo.save(new ProductEntity(2L, "Sample Product 2", "Description for Sample Product 2", 65L, "USD", "Books", "https://example.com/product2.jpg"));
            productRepo.save(new ProductEntity(3L, "Sample Product 3", "Description for Sample Product 3", 76L, "USD", "Toys", "https://example.com/product3.jpg"));

            customerRepo.save(new CustomerEntity(1L, "John Doe", "john.doe@example.com", "123-456-7890", "123 Main St, Anytown, USA"));
            customerRepo.save(new CustomerEntity(2L, "Jane Smith", "jane.smith@example.com", "234-567-8901", "456 Oak St, Anytown, USA"));
            customerRepo.save(new CustomerEntity(3L, "Alice Johnson", "alice.johnson@example.com", "345-678-9012", "789 Pine St, Anytown, USA"));
        };
    }
}

