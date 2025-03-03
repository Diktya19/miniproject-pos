package com.bootcamp.northwind.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_orders")
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    @Column(name = "ship_via")
    private String shipVia;

    @Column(name = "freight")
    private String freight;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shipAddress;

    @Column(name = "ship_city")
    private String shipCity;

    @Column(name = "ship_region")
    private String shipRegion;

    @Column(name = "ship-postal_code")
    private String shipPostalCode;

    @Column(name = "ship_country")
    private String shipCountry;
}
