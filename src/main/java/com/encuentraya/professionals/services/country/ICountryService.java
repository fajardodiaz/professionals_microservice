package com.encuentraya.professionals.services.country;

import com.encuentraya.professionals.models.Country;

import java.util.List;

public interface ICountryService {
    Country getCountryById(Long id);
    Country getCountryByName(String name);
    List<Country> getAllCountries();
    Country addCountry(Country country);
    Country updateCountry(Country country);
    void deleteCountry(Long id);
}
