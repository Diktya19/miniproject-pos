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
@Table(name = "tbl_employee_territories")
public class EmployeeTerritoriesEntity {
    @Id
    @Column(name = "employee_territories_id")
    private String employeeTerritories;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "territory_id")
    private String territoryId;
}
