package com.encuentraya.professionals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String completeName;
    
    @ManyToMany
    @JoinTable(
            name = "professional_category",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "professional_subcategory",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    Set<SubCategory> subcategories;
}
