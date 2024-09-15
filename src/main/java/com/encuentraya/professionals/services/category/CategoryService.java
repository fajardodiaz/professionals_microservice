package com.encuentraya.professionals.services.category;

import com.encuentraya.professionals.exceptions.AlreadyExistsException;
import com.encuentraya.professionals.exceptions.ObjectNotFoundException;
import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    
    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository :: save)
                .orElseThrow(()-> new AlreadyExistsException(category.getName() + " already exists"));
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
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete,
                ()-> {throw new ObjectNotFoundException("Category Not Found!");
        });
    }
    
    @Override
    public Category updateCategory(Category category, long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(()-> new ObjectNotFoundException("Category Not Found!"));
    }
}
