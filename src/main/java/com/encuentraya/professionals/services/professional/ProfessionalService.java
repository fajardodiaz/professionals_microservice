package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.dtos.professional_category.ProfessionalCategoryDto;
import com.encuentraya.professionals.dtos.professional_subcategory.ProfessionalSubcategoryDto;
import com.encuentraya.professionals.exceptions.ObjectNotFoundException;
import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.Country;
import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.models.SubCategory;
import com.encuentraya.professionals.repository.CategoryRepository;
import com.encuentraya.professionals.repository.CountryRepository;
import com.encuentraya.professionals.repository.ProfessionalRepository;
import com.encuentraya.professionals.dtos.professional.AddProfessionalDto;
import com.encuentraya.professionals.dtos.professional.UpdateProfessionalDto;
import com.encuentraya.professionals.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessionalService implements IProfessionalService {
    private final ProfessionalRepository professionalRepository;
    private final CountryRepository countryRepository;
    private CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    
    @Override
    public Professional getProfessionalById(Long id) {
        return professionalRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Professional not found"));
    }
    
    @Override
    public List<Professional> getAllProfessionals() {
        return professionalRepository.findAll();
    }

    @Override
    public Professional addProfessional(AddProfessionalDto professional) {
        Country country = Optional.ofNullable(countryRepository.findByName(professional.getCountry().getName()))
                .orElseGet(()-> {
                    Country newCountry = new Country(professional.getCountry().getName());
                    return countryRepository.save(newCountry);
                });
        professional.setCountry(country);
        return professionalRepository.save(createProfessional(professional, country));
    }
    
    private Professional createProfessional(AddProfessionalDto request, Country country){
        return new Professional(
                request.getCompleteName(),
                request.getCountryUniqueID(),
                country,
                request.getEmail(),
                request.getPhone(),
                request.getAddress(),
                request.getRating()
        );
    }

    @Override
    public Professional updateProfessional(UpdateProfessionalDto professional, Long id) {
        return professionalRepository.findById(id)
                .map(existingProfessional -> updateExistingProfessional(existingProfessional, professional))
                .map(professionalRepository::save)
                .orElseThrow(() -> new ObjectNotFoundException("Professional not found"));
    }
    
    private Professional updateExistingProfessional(Professional existingProfessional, UpdateProfessionalDto request) {
        existingProfessional.setCompleteName(request.getCompleteName());
        existingProfessional.setCountryUniqueID(request.getCountryUniqueID());
        existingProfessional.setEmail(request.getEmail());
        existingProfessional.setPhone(request.getPhone());
        existingProfessional.setAddress(request.getAddress());
        existingProfessional.setRating(request.getRating());
        
        Country country = countryRepository.findByName(request.getCountry().getName());
        existingProfessional.setCountry(country);
        return existingProfessional;
    }
    

    @Override
    public void deleteProfessional(Long id) {
        professionalRepository.findById(id).ifPresentOrElse(professionalRepository :: delete ,
                ()->{ throw new ObjectNotFoundException("Professional not found");
        });
    }

    @Override
    public Long countProfessionals() {
        return professionalRepository.count();
    }

    @Override
    public Long countProfessionalsByCategory(String category) {
        return 0L;
    }

    @Override
    public Long countProfessionalsBySubCategory(String subCategory) {
        return 0L;
    }

    //Associate categories and subcategories
    @Override
    public Professional associateCategoriesToProfessional(ProfessionalCategoryDto professionalCategoryDto) {
        Professional professional = professionalRepository.findById(professionalCategoryDto.getProfessionalId())
                .orElseThrow(()-> new ObjectNotFoundException("Professional not found"));
        
        professional.getCategories()
                .addAll(professionalCategoryDto.getCategories()
                .stream()
                .map(c -> {
                    Category newCategory = categoryRepository.findById(c.getId()).orElseThrow(()-> new ObjectNotFoundException("Category not found"));
                    newCategory.getProfessionals().add(professional);
                    return newCategory;
                }).toList()
        );
        
        return professionalRepository.save(professional);
    }

    @Override
    public Professional associateSubCategoriesToProfessional(ProfessionalSubcategoryDto professionalSubCategoryDto) {
        Professional professional = professionalRepository.findById(professionalSubCategoryDto.getProfessionalId())
                .orElseThrow(()-> new ObjectNotFoundException("Professional not found"));

        professional.getSubcategories()
                .addAll(professionalSubCategoryDto.getSubCategories()
                        .stream()
                        .map(c -> {
                            SubCategory newSubCategory = subCategoryRepository.findById(c.getId()).orElseThrow(()-> new ObjectNotFoundException("SubCategory not found"));
                            newSubCategory.getProfessionals().add(professional);
                            return newSubCategory;
                        }).toList()
                );

        return professionalRepository.save(professional);
    }
}
