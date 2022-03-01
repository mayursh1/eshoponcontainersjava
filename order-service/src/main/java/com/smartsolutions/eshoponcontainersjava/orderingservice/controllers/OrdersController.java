package com.smartsolutions.eshoponcontainersjava.orderingservice.controllers;

import com.smartsolutions.eshoponcontainersjava.orderingservice.models.*;
import com.smartsolutions.eshoponcontainersjava.orderingservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PutMapping("cancel")
    public ResponseEntity<String> cancel(@RequestBody CancelOrderRequest order) {
        orderService.cancelOrder(order);
        return ResponseEntity.ok("Cancelled : " + order.getOrderNumber());
    }

    @PutMapping("ship")
    public ResponseEntity<String> ship(@RequestBody ShipOrderRequest order) {
        return ResponseEntity.ok("Shipped : " + order.getOrderNumber());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderSummaryResponse> getOrder(@PathVariable int orderNumber) {
        return ResponseEntity.ok(orderService.getOrder(orderNumber));
    }

    @GetMapping()
    public ResponseEntity<List<OrderSummaryResponse>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("cardtypes")
    public ResponseEntity<List<CardTypeResponse>> getCardTypes() {
        return ResponseEntity.ok(orderService.getCardTypes());
    }

    @PostMapping("draft")
    public ResponseEntity<OrderDraftResponse> getCardTypes(@RequestBody OrderDraftRequest request) {
        return ResponseEntity.ok(orderService.draftOrder(request));
    }

}
