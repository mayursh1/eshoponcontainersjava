package com.smartsolutions.eshoponcontainersjava.orderingservice.services;

import com.smartsolutions.eshoponcontainersjava.orderingservice.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void cancelOrder(CancelOrderRequest cancelOrderRequest) {

    }

    @Override
    public void ship(ShipOrderRequest shipOrderRequest) {

    }

    @Override
    public OrderSummaryResponse getOrder(int orderNumber) {
        return null;
    }

    @Override
    public List<OrderSummaryResponse> getOrders() {
        return null;
    }

    @Override
    public List<CardTypeResponse> getCardTypes() {
        return null;
    }

    @Override
    public OrderDraftResponse draftOrder(OrderDraftRequest orderDraftRequest) {
        return null;
    }
}
