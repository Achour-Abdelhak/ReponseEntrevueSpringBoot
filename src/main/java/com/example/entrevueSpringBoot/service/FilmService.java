package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.exception.FilmNotFoundException;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepo;

    @Autowired
    public FilmService(FilmRepository filmRepo) {
        this.filmRepo = filmRepo;
    }

    public Film addFilm(Film film){
        return  filmRepo.save(film);
    }

    public List<Film> findAllFilms(){
        return  filmRepo.findAll();
    }




    public Film findFilmById(Long id){
        return  filmRepo.findFilmById(id).orElseThrow(()-> new FilmNotFoundException("Film de "+ id +"non trouvé"));

    }

}
