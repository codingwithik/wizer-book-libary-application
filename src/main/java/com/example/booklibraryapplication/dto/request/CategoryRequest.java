package com.example.booklibraryapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
public @Data class CategoryRequest {

    @NotNull(message = "Category name is required")
    private String name;
}
