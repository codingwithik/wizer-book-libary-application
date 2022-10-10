package com.example.booklibraryapplication.services.category;

import com.example.booklibraryapplication.dto.request.CategoryRequest;
import com.example.booklibraryapplication.model.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(CategoryRequest request);
    List<Category> getCategories();
    Category getCategory(long id);
    Category editCategory(long id, CategoryRequest request);
}
