package com.bootcamp.northwind.model.request;

import com.bootcamp.northwind.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;
    private String productName;
    private Long supplierId;
    private String supplierName;
    private Long categoryId;
    private String categoryName;
    private Integer qtyUnit;
    private Double unitPrice;
    private Integer unitStock;
    private Integer unitsOrder;
    private Integer reorderLevel;
    private Integer discontinued;

    public ProductRequest(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
        this.id = entity.getId();

        if (entity.getSupplier() != null){
            this.supplierId = entity.getSupplier().getId();
            this.supplierName = entity.getSupplier().getCompanyName();
        }
    }
}
