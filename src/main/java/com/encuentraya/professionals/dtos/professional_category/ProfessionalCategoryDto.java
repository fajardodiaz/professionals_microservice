package com.encuentraya.professionals.dtos.professional_category;

import com.encuentraya.professionals.models.Category;
import lombok.Data;

import java.util.Set;

@Data
public class ProfessionalCategoryDto {
    private Long professionalId;
    private Set<Category> categories;
}
