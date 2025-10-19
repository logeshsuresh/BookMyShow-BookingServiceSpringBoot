package com.logesh.bookmyshow.entities;

import jakarta.persistence.Entity;
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
public class City extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "city")
    private Set<Theatre> theatres;

}
