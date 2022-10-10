package com.example.booklibraryapplication.services.category;

import com.example.booklibraryapplication.dto.request.CategoryRequest;
import com.example.booklibraryapplication.exception.NotFoundException;
import com.example.booklibraryapplication.model.Category;
import com.example.booklibraryapplication.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryRequest request) {
        Category newCat = new Category();
        newCat.setName(request.getName());
        newCat = categoryRepository.save(newCat);
        return newCat;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public Category editCategory(long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Category not found"));
        category.setName(request.getName());
        category = categoryRepository.save(category);
        return category;
    }
}
