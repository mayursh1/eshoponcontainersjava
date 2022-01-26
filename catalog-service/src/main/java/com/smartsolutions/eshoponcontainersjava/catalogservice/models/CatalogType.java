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
public class CatalogType {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private int id;
    @JsonProperty("type")
    private String type;

    @OneToMany(targetEntity=CatalogItem.class, mappedBy="catalogType", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<CatalogItem> catalogItems;
}
