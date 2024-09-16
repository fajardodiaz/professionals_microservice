package com.encuentraya.professionals.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany(mappedBy = "categories")
    private Set<Professional> professionals = new HashSet<>();
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubCategory> subcategories;
    
    public Category(String name) {
        this.name = name;
    }
}

