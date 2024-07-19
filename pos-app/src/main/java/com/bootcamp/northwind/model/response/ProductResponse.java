package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String productName;
    private String supplierId;
    private String categoryId;
    private Integer qtyUnit;
    private Double unitPrice;
    private Integer unitStock;
    private Integer unitsOrder;
    private Integer reorderLevel;
    private Integer discontinued;
}
