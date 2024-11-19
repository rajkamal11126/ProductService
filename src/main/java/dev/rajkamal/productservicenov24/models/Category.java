package dev.rajkamal.productservicenov24.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    List<Product> products;
}

/*
createdAT
lastModifiedAt
 */
/*
Can one prod have multiple categories?
1 m
m 1 => m:m
mapping table
 */
