package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.models.SubCategory;
import com.encuentraya.professionals.repository.ProfessionalRepository;

import java.util.List;

public class ProfessionalService implements IProfessionalService {
    private ProfessionalRepository professionalRepository;
    
    @Override
    public Professional getProfessionalById(Long id) {
        return null;
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return List.of();
    }

    @Override
    public List<Professional> getProfessionalsByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public List<Professional> getProfessionalsBySubCategory(Long subCategoryId) {
        return List.of();
    }

    @Override
    public Professional addProfessional(Professional professional) {
        return null;
    }

    @Override
    public Professional updateProfessional(Professional professional) {
        return null;
    }

    @Override
    public void deleteProfessional(Long id) {

    }
}
