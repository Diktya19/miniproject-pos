package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookupResponse {
    private String id;
    private String groups;
    private String code;
    private String name;
    private String position;
    private Boolean active;
}
