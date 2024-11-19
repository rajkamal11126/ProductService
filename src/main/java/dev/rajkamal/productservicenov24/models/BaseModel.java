package dev.rajkamal.productservicenov24.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
    private boolean isDeleted;
}
