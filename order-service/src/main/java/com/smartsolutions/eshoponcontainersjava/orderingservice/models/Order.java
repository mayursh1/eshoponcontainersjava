package com.smartsolutions.eshoponcontainersjava.orderingservice.models;

import com.smartsolutions.eshoponcontainersjava.orderingservice.models.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {

    private LocalDateTime orderDate;
    private Address address;
    private int buyerId;
    private OrderStatus orderStatus;
    private String description;
    private boolean isDraft;
    private List<OrderItem> items;
    private int orderNumber;
}
