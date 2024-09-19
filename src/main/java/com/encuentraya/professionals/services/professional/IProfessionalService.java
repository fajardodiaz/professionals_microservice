package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.dtos.professional_category.ProfessionalCategoryDto;
import com.encuentraya.professionals.dtos.professional_subcategory.ProfessionalSubcategoryDto;
import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.dtos.professional.AddProfessionalDto;
import com.encuentraya.professionals.dtos.professional.UpdateProfessionalDto;

import java.util.List;
import java.util.Set;

public interface IProfessionalService {
    Professional getProfessionalById(Long id);
    List<Professional> getAllProfessionals();
    Professional addProfessional(AddProfessionalDto professional);
    Professional updateProfessional(UpdateProfessionalDto professional, Long id);
    void deleteProfessional(Long id);
    Long countProfessionals();
    Long countProfessionalsByCategory(String category);
    Long countProfessionalsBySubCategory(String subCategory);
    // Associate categories to professional
    Professional associateCategoriesToProfessional(ProfessionalCategoryDto professionalCategoryDto);
    Professional associateSubCategoriesToProfessional(ProfessionalSubcategoryDto professionalSubCategoryDto);
}
