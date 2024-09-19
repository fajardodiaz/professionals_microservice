package com.encuentraya.professionals.dtos.professional_subcategory;

import com.encuentraya.professionals.models.SubCategory;
import lombok.Data;

import java.util.Set;

@Data
public class ProfessionalSubcategoryDto {
    private Long professionalId;
    private Set<SubCategory> subCategories;
}
