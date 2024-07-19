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
@Table(name = "tbl_states")
public class StatesEntity {
    @Id
    @Column(name = "states_id")
    private String id;

    @Column(name = "states_name")
    private String statesName;

    @Column(name = "states_abbr")
    private String statesAbbr;

    @Column(name = "states_region")
    private String statesRegion;
}
