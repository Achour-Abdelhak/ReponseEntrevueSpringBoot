package com.example.entrevueSpringBoot.controlleur;

import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class FilmControlleur {
    private final FilmService filmService;

    public FilmControlleur(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id){
        Film utilisateur =  filmService.findFilmById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }


    @PostMapping("/films")
    public ResponseEntity<Film> addUtilisateur(@RequestBody Film film){
        Film newUtilisateur = filmService.addFilm(film);
        return new ResponseEntity<>(newUtilisateur,HttpStatus.CREATED);

    }

}
