package com.smartsolutions.eshoponcontainersjava.catalogservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class CatalogBrand {
    @Id
    @GeneratedValue
    @JsonProperty("id")
    private int id;
    @JsonProperty("brand")
    private String brand;

    @OneToMany(targetEntity=CatalogItem.class, mappedBy="catalogBrand", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<CatalogItem> items;
}
