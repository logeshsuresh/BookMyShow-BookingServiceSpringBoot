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
public class User extends BaseModel  {

    private String username;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

}
