package com.example.entrevueSpringBoot.controlleur;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class FilmControlleurTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    FilmRepository filmRepository;

    Film FILM1 = new Film(1L,"Message in the bootle","message dans la mer");
    Film FILM2 = new Film(2L,"Fore one Dollar more","film culte westerne");


    @Test
    void getFilmById()throws Exception {
        Mockito.when( filmRepository.findById(FILM1.getId())).thenReturn(java.util.Optional.of(FILM1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/films/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.titre", is("Message in the bootle")));
    }

    @Test
    void addUtilisateur()throws Exception {
        Film film = new Film(3L,"Vaccance de l'inspecteur Tahar","comedie");

        Mockito.when(filmRepository.save(film)).thenReturn(film);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("api/films")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(film));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.titre", is("Vaccance de l'inspecteur Tahar")));
    }
}