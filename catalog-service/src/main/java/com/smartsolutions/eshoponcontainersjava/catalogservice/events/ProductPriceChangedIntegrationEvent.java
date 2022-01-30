package com.smartsolutions.eshoponcontainersjava.catalogservice.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductPriceChangedIntegrationEvent extends IntegrationEvent {

    @JsonProperty("productId")
    private int productId;
    @JsonProperty("oldPrice")
    private BigDecimal oldPrice;
    @JsonProperty("newPrice")
    private BigDecimal newPrice;

    public ProductPriceChangedIntegrationEvent(int productId, BigDecimal oldPrice, BigDecimal newPrice) {
        this.productId = productId;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }
}
