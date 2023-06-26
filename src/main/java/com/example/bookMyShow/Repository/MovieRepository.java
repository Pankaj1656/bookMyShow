package com.example.bookMyShow.Repository;

import com.example.bookMyShow.Modals.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie,Integer> {
}
