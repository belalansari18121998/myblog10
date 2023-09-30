package com.myblog10.payload;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String title;
    private String description;
    private String content;
}
