package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatesResponse {
    private String id;
    private String statesName;
    private String statesAbbr;
    private String statesRegion;
}
