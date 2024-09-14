package com.encuentraya.professionals.services.country;

import com.encuentraya.professionals.models.Country;
import com.encuentraya.professionals.repository.CountryRepository;

import java.util.List;

public class CountryService implements ICountryService {
    private CountryRepository countryRepository;
    
    @Override
    public Country getCountryById(Long id) {
        return null;
    }

    @Override
    public Country getCountryByName(String name) {
        return null;
    }

    @Override
    public List<Country> getAllCountries() {
        return List.of();
    }

    @Override
    public Country addCountry(Country country) {
        return null;
    }

    @Override
    public Country updateCountry(Country country) {
        return null;
    }

    @Override
    public void deleteCountry(Long id) {

    }
}
