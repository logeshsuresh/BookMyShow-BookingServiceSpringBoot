package com.logesh.bookmyshow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theatre extends BaseModel {

    private String name;

    private String address;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theatre")
    private Set<Auditorium> auditoriums;

}
