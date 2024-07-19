package com.bootcamp.northwind.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_shippers")
public class ShippersEntity {
    @Id
    @Column(name = "shippers_id")
    private String id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone")
    private String phone;
}
