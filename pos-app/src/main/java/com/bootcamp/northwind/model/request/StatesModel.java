package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatesModel {
    private String id;
    private String statesName;
    private String statesAbbr;
    private String statesRegion;
}
