package com.encuentraya.professionals.services.country;

import com.encuentraya.professionals.exceptions.AlreadyExistsException;
import com.encuentraya.professionals.exceptions.ObjectNotFoundException;
import com.encuentraya.professionals.models.Country;
import com.encuentraya.professionals.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

public class CountryService implements ICountryService {
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Country Not Found"));
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Country addCountry(Country country) {
        return Optional.of(country).filter(c -> !countryRepository.existsByName(c.getName()))
                .map(countryRepository :: save)
                .orElseThrow(()-> new AlreadyExistsException(country.getName() + " already exists"));
    }

    @Override
    public Country updateCountry(Country country, Long id) {
        return Optional.ofNullable(getCountryById(id)).map(oldCountry ->{
            oldCountry.setName(country.getName());
            return countryRepository.save(oldCountry);
        }).orElseThrow(()-> new ObjectNotFoundException("Country Not Found"));
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.findById(id).ifPresentOrElse(countryRepository::delete,
                () -> {throw new ObjectNotFoundException("Country Not Found");
        });
    }
}
