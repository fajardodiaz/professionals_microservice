package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.models.SubCategory;

import java.util.List;

public interface IProfessionalService {
    Professional getProfessionalById(Long id);
    List<Professional> getAllProfessionals();
    List<Professional> getProfessionalsByCategory(Long categoryId);
    List<Professional> getProfessionalsBySubCategory(Long subCategoryId);
    Professional addProfessional(Professional professional);
    Professional updateProfessional(Professional professional);
    void deleteProfessional(Long id);
}
