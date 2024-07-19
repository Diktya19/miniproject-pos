package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsModel {
    private String id;
    private String orderId;
    private String productId;
    private Double unitPrice;
    private Integer quantity;
    private Integer discount;
}
