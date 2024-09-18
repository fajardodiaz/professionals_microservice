package com.encuentraya.professionals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Getter
@Setter
@NoArgsConstructor
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String completeName;
    
    @Column(nullable = false, unique = true)
    private String countryUniqueID;
    
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(unique = true)
    private String email;
    
    private String phone;
    private String address;
    private double rating;
    
    @ManyToMany
    @JoinTable(
            name = "professional_category",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "professional_subcategory",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private Set<SubCategory> subcategories = new HashSet<>();

    public Professional(String completeName, String countryUniqueID, Country country, String email, String phone, String address, double rating) {
        this.completeName = completeName;
        this.countryUniqueID = countryUniqueID;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.rating = rating;
    }
}
