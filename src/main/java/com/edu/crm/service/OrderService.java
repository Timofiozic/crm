package com.edu.crm.service;

import com.edu.crm.adapters.OrderAdapter;
import com.edu.crm.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderService {

    private OrderAdapter orderAdapter;

    @GetMapping("/{id}")
    @ResponseBody
    public Order getOrder(@PathVariable Long id) {
        return orderAdapter.read(id);
    }

    @Autowired
    public void setOrderAdapter(OrderAdapter orderAdapter) {
        this.orderAdapter = orderAdapter;
    }
}
