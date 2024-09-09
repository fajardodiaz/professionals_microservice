package com.encuentraya.professionals.services.category;

import com.encuentraya.professionals.models.Category;
import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(long id);
    void deleteCategoryById(long id);
    Category updateCategory(Category category, long id);
}
