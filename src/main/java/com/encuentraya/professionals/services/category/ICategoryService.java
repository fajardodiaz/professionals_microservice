package com.encuentraya.professionals.services.category;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.requests.category.AddCategoryRequest;
import com.encuentraya.professionals.requests.category.UpdateCategoryRequest;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(long id);
    Category getCategoryByName(String name);
    void deleteCategoryById(long id);
    Category updateCategory(Category category, long id);
}
