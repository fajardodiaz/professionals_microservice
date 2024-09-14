package com.encuentraya.professionals.services.category;

import com.encuentraya.professionals.exceptions.ObjectNotFoundException;
import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    
    private final CategoryRepository categoryRepository;
    
    @Override
    public Category addCategory(Category category) {
        return createCategory(category);
        
    }
    
    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }
    

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Category Not Found!"));
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete,
                ()-> {throw new ObjectNotFoundException("Category Not Found!");
        });
    }

    @Override
    public Category updateCategory(Category category, long id) {
        return null;
    }
}
