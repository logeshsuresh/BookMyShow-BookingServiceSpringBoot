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
public class Movie extends BaseModel {

    private String name;

    private String poster;

    @OneToMany(mappedBy = "movie")
    private Set<Show> shows;

}
