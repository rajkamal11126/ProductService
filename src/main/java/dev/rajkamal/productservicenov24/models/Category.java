package dev.rajkamal.productservicenov24.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private String title;

}

/*
Can one prod have multiple categories?
1 m
m 1 => m:m
mapping table
 */
