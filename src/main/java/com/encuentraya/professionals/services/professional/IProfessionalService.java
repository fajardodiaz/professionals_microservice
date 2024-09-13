package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.models.SubCategory;

import java.util.List;

public interface IProfessionalService {
    Professional getProfessionalById(Long id);
    List<Professional> getAllProfessionals();
    List<Professional> getProfessionalsByCategory(Category category);
    List<Professional> getProfessionalsBySubCategory(SubCategory subCategory);
}
