package com.nosql.demonosql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String email;
}
