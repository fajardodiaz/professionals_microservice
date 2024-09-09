package com.encuentraya.professionals.services.subcategory;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.SubCategory;

import java.util.List;

public class SubCategoryService implements ISubCategoryService {
    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {
        return null;
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return List.of();
    }

    @Override
    public List<SubCategory> getSubCategoriesByCategory(Category category) {
        return List.of();
    }

    @Override
    public SubCategory getSubCategoryById(long id) {
        return null;
    }

    @Override
    public void deleteSubCategoryById(long id) {

    }

    @Override
    public SubCategory updateSubCategory(SubCategory subCategory, long id) {
        return null;
    }
}
