package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookupModel {
    private String id;
    private String groups;
    private String code;
    private String name;
    private String position;
    private Boolean active;
}
