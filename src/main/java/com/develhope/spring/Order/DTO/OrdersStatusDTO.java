package com.develhope.spring.Order.DTO;

import com.develhope.spring.Order.Entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersStatusDTO {
    private OrderStatus orderStatus;

    @Override
    public String toString() {
        return "OrdersStatusDTO{" +
                "orderStatus=" + orderStatus +
                '}';
    }
}
