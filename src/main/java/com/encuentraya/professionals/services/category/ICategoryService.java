package com.encuentraya.professionals.services.category;

import com.encuentraya.professionals.models.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    void deleteCategoryById(Long id);
    Category updateCategory(Category category, Long id);
}
