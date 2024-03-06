package com.develhope.spring.Order.Controller;

import com.develhope.spring.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {
    @Autowired
    OrderService orderService;
}
