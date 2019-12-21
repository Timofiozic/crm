package com.edu.crm.service;

import com.edu.crm.adapters.OrderAdapter;
import com.edu.crm.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderService {

    @Autowired
    private OrderAdapter orderAdapter;

    @GetMapping("/{id}")
    @ResponseBody
    public Orders getOrder(@PathVariable String id){
        return orderAdapter.read(Integer.parseInt(id));
    }
}
