package dev.rajkamal.productservicenov24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "productdb")
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
   private Category category;
    private String imageUrl;
}

/*
Cardinality
P C
1 1 -> m:1
 */