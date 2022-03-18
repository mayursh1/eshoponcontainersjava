package com.smartsolutions.eshoponcontainersjava.orderingservice.models;

import com.smartsolutions.eshoponcontainersjava.orderingservice.models.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue
    private int orderId;
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;
    private int buyerId;
    private OrderStatus orderStatus;
    private String description;
    private boolean isDraft;

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> items;
    private int orderNumber;

    private BigDecimal total;
}
