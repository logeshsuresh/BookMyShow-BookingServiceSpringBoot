package com.logesh.bookmyshow.repositories;

import com.logesh.bookmyshow.entities.Show;
import com.logesh.bookmyshow.entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllByShowId(Long showId);
}
