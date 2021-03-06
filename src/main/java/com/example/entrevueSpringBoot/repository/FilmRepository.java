package com.example.entrevueSpringBoot.repository;


import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film,Long> {
    Optional<Film> findFilmById(Long id);
}
