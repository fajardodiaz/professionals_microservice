package com.encuentraya.professionals.services.subcategory;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategory> getAllSubCategories();

    List<SubCategory> getSubCategoriesByCategory(String category);

    SubCategory getSubCategorieByName(String name);

    SubCategory getSubCategoryById(Long id);

    SubCategory addSubCategory(SubCategory subCategory);

    SubCategory updateSubCategory(SubCategory subCategory, long id);

    void deleteSubCategoryById(Long id);
}
