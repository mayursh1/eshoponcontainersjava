package com.smartsolutions.eshoponcontainersjava.catalogservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class CatalogItem {

    @Id
    private int id;
    private String name;
    private String description;

    private BigDecimal price;

    private String pictureFileName;

    private String pictureUri;

    private int catalogTypeId;

    private CatalogType catalogType;

    private int catalogBrandId;

    private CatalogBrand catalogBrand;

    // Quantity in stock
    private int availableStock;

    // Available stock at which we should reorder
    private int restockThreshold;


    // Maximum number of units that can be in-stock at any time (due to physicial/logistical constraints in warehouses)
    public int maxStockThreshold;
}
