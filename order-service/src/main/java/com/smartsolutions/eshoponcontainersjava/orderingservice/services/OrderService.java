package com.smartsolutions.eshoponcontainersjava.orderingservice.services;

import com.smartsolutions.eshoponcontainersjava.orderingservice.models.*;
import java.util.List;

public interface OrderService {
    public void cancelOrder(CancelOrderRequest cancelOrderRequest);
    public void ship(ShipOrderRequest shipOrderRequest);
    public OrderSummaryResponse getOrder(int orderNumber);
    public List<OrderSummaryResponse> getOrders();
    public List<CardTypeResponse> getCardTypes();
    public OrderDraftResponse draftOrder(OrderDraftRequest orderDraftRequest);
}
