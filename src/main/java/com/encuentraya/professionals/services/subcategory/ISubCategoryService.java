package com.encuentraya.professionals.services.subcategory;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategory> getAllSubCategories();
    SubCategory getSubCategorieByName(String name);
    List<SubCategory> getSubCategoriesByCategory(Category category);
    SubCategory getSubCategoryById(long id);
    SubCategory addSubCategory(SubCategory subCategory);
    SubCategory updateSubCategory(SubCategory subCategory, long id);
    void deleteSubCategoryById(long id);
}
