package com.encuentraya.professionals.services.subcategory;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    SubCategory addSubCategory(SubCategory subCategory);
    List<SubCategory> getAllSubCategories();
    List<SubCategory> getSubCategoriesByCategory(Category category);
    SubCategory getSubCategoryById(long id);
    void deleteSubCategoryById(long id);
    SubCategory updateSubCategory(SubCategory subCategory, long id);
}
