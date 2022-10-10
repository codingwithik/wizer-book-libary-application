package com.example.booklibraryapplication.controllers;

import com.example.booklibraryapplication.dto.request.CategoryRequest;
import com.example.booklibraryapplication.model.Category;
import com.example.booklibraryapplication.services.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/v1/category")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryRequest request) {
        return new ResponseEntity<>(categoryService.addCategory(request), HttpStatus.CREATED);
    }

    @GetMapping("/v1/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id) {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }

    @GetMapping("/v1/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @PutMapping("/v1/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @Valid @RequestBody CategoryRequest request) {
        return new ResponseEntity<>(categoryService.editCategory(id, request), HttpStatus.OK);
    }

}
