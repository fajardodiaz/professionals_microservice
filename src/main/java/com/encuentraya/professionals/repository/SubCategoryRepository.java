package com.encuentraya.professionals.repository;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory findByName(String name);

    List<SubCategory> findByCategory(Category category);

    boolean existsByName(String name);
}