package com.encuentraya.professionals.services.professional;

import com.encuentraya.professionals.exceptions.ObjectNotFoundException;
import com.encuentraya.professionals.models.Country;
import com.encuentraya.professionals.models.Professional;
import com.encuentraya.professionals.repository.CountryRepository;
import com.encuentraya.professionals.repository.ProfessionalRepository;
import com.encuentraya.professionals.requests.professional.AddProfessionalRequest;
import com.encuentraya.professionals.requests.professional.UpdateProfessionalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalService implements IProfessionalService {
    private final ProfessionalRepository professionalRepository;
    private final CountryRepository countryRepository;
    
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
    public Professional addProfessional(AddProfessionalRequest professional) {
        Country country = Optional.ofNullable(countryRepository.findByName(professional.getCountry().getName()))
                .orElseGet(()-> {
                    Country newCountry = new Country(professional.getCountry().getName());
                    return countryRepository.save(newCountry);
                });
        professional.setCountry(country);
        return professionalRepository.save(createProfessional(professional, country));
    }
    
    private Professional createProfessional(AddProfessionalRequest request, Country country){
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
    public Professional updateProfessional(UpdateProfessionalRequest professional, Long id) {
        return professionalRepository.findById(id)
                .map(existingProfessional -> updateExistingProfessional(existingProfessional, professional))
                .map(professionalRepository::save)
                .orElseThrow(() -> new ObjectNotFoundException("Professional not found"));
    }
    
    private Professional updateExistingProfessional(Professional existingProfessional, UpdateProfessionalRequest request) {
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
}
