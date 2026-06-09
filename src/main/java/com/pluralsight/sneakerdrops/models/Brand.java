package com.pluralsight.sneakerdrops.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brand {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Brand(String name) {
        this.name = name;
    }
    public Brand() {}
}


