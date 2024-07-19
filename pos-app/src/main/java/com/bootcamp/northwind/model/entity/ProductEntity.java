package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private Long supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @Column(name = "qty_unit")
    private Integer qtyUnit;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "unit_stock")
    private Integer unitStock;

    @Column(name = "units_order")
    private Integer unitsOrder;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "discontinued")
    private Integer discontinued;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public ProductEntity(ProductRequest request) {
        BeanUtils.copyProperties(request, this);
    }

    public void setCategories(CategoryEntity categoryEntity) {
    }
}
