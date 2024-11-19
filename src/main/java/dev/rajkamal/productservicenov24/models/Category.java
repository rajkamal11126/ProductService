package dev.rajkamal.productservicenov24.models;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;

//    @OneToMany(mappedBy = "category")
//    List<Product> products;
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
