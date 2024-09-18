package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.requests.professional.AddProfessionalRequest;
import com.encuentraya.professionals.requests.professional.UpdateProfessionalRequest;

import java.util.List;

public interface IProfessionalService {
    Professional getProfessionalById(Long id);
    List<Professional> getAllProfessionals();
    Professional addProfessional(AddProfessionalRequest professional);
    Professional updateProfessional(UpdateProfessionalRequest professional, Long id);
    void deleteProfessional(Long id);
    Long countProfessionals();
    Long countProfessionalsByCategory(String category);
    Long countProfessionalsBySubCategory(String subCategory);
}
