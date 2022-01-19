package com.smartsolutions.eshoponcontainersjava.catalogservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class CatalogBrand {
    @Id
    private int id;
    private String brand;
}
