package com.smartsolutions.eshoponcontainersjava.orderingservice.repositories;

import com.smartsolutions.eshoponcontainersjava.orderingservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
