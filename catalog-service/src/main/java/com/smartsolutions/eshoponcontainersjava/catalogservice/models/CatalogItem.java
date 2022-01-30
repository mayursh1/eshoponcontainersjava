package com.smartsolutions.eshoponcontainersjava.catalogservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.math.BigDecimal;

//@JsonDeserialize(builder = CatalogItem.CatalogItemBuilder.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class CatalogItem {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("descripton")
    private String description;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("pictureFileName")
    private String pictureFileName;

    @JsonProperty("pictureUri")
    private String pictureUri;

    @ManyToOne
    @JoinColumn(name = "typeId")
    @JsonProperty("catalogType")
    private CatalogType catalogType;


    @ManyToOne
    @JoinColumn(name = "brandId")
    @JsonProperty("catalogBrand")
    private CatalogBrand catalogBrand;

    // Quantity in stock
    @JsonProperty("availableStock")
    private int availableStock;

    // Available stock at which we should reorder
    @JsonProperty("restockThreshold")
    private int restockThreshold;


    // Maximum number of units that can be in-stock at any time (due to physicial/logistical constraints in warehouses)
    @JsonProperty("maxStockThreshold")
    public int maxStockThreshold;
/*

    @JsonPOJOBuilder(withPrefix = "")
    public static class CatalogItemBuilder {

    }
*/
}
