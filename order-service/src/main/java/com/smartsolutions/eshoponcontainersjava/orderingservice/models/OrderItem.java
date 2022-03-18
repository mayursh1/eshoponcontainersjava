package com.smartsolutions.eshoponcontainersjava.orderingservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private int orderItemId;
    private String productName;
    private int units;
    private double unitPrice;
    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

}
