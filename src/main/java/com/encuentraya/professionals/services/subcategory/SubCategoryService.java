package com.encuentraya.professionals.services.subcategory;

import com.encuentraya.professionals.exceptions.AlreadyExistsException;
import com.encuentraya.professionals.exceptions.ObjectNotFoundException;
import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.SubCategory;
import com.encuentraya.professionals.repository.SubCategoryRepository;

import java.util.List;
import java.util.Optional;

public class SubCategoryService implements ISubCategoryService {
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategorieByName(String name) {
        return subCategoryRepository.findByName(name);
    }

    @Override
    public List<SubCategory> getSubCategoriesByCategory(Category category) {
        return subCategoryRepository.findByCategory(category);
    }

    @Override
    public SubCategory getSubCategoryById(long id) {
        return subCategoryRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("SubCategory Not Found"));
    }

    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {
        return Optional.of(subCategory).filter(s -> !subCategoryRepository.existsByName(s.getName()))
                .map(subCategoryRepository :: save)
                .orElseThrow(()-> new AlreadyExistsException(subCategory.getName() + " already exists"));
    }

    @Override
    public SubCategory updateSubCategory(SubCategory subCategory, long id) {
        return Optional.ofNullable(getSubCategoryById(id)).map(oldSubCategory ->{
            oldSubCategory.setName(subCategory.getName());
            return subCategoryRepository.save(oldSubCategory);
        }).orElseThrow(()-> new ObjectNotFoundException("SubCategory Not Found"));
    }

    @Override
    public void deleteSubCategoryById(long id) {
        subCategoryRepository.findById(id).ifPresentOrElse(subCategoryRepository::delete, () -> {
            throw new ObjectNotFoundException("SubCategory Not Found");
        });
    }
}
