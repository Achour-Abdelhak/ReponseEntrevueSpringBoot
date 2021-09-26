package com.example.entrevueSpringBoot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="Acteur")
@Table(name="acteur")
public class Acteur implements Serializable {

    @Id
    @SequenceGenerator(
            name="acteur_sequence",
            sequenceName = "acteur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "acteurr_sequence"
    )

    @Column(
            name="acteur_id",
            nullable = false,
            updatable = false
    )
    private Long id ;

    @Column(
            name="nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;

    @Column(
            name="prenom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String prenom;

    @ManyToMany(
            mappedBy = "acteurs"
    )
    private List<Film> films= new ArrayList<>();

    public Acteur() {
    }

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
