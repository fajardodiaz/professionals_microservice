package com.encuentraya.professionals.requests.professional;

import com.encuentraya.professionals.models.Category;
import com.encuentraya.professionals.models.Country;
import com.encuentraya.professionals.models.SubCategory;
import lombok.Data;

import java.util.Set;

@Data
public class AddProfessionalRequest {
    private String completeName;
    private String countryUniqueID;
    private Country country;
    private String email;
    private String phone;
    private String address;
    private double rating;
}
