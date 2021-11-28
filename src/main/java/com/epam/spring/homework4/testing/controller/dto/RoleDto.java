package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Data
@Builder
public class RoleDto {
    @Min(1)
    @Max(2)
    private int id;

    @NotBlank
    private String name;
}
