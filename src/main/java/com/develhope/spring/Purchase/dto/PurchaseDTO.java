package com.develhope.spring.Purchase.dto;

import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Purchase.Entity.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    private BigDecimal advance;
    private Boolean isPaid;
    private PurchaseStatus purchaseStatus;
    private Orders orders;

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", purchaseStatus=" + purchaseStatus +
                ", orders=" + orders +
                '}';
    }
}