package com.encuentraya.professionals.requests.professional;

import com.encuentraya.professionals.models.Country;
import lombok.Data;

@Data
public class UpdateProfessionalRequest {
    private Long id;
    private String completeName;
    private String countryUniqueID;
    private Country country;
    private String email;
    private String phone;
    private String address;
    private double rating;
}