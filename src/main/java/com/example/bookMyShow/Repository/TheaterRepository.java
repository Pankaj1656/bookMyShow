package com.example.bookMyShow.Repository;

import com.example.bookMyShow.Modals.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    Theater findByLocation(String location);


}
