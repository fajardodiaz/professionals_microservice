package com.encuentraya.professionals.services.country;

import com.encuentraya.professionals.models.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    Country getCountryByName(String name);
    Country addCountry(Country country);
    Country updateCountry(Country country, Long id);
    void deleteCountry(Long id);
}
