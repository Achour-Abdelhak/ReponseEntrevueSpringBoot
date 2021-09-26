package com.example.entrevueSpringBoot.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name="Film")
@Table(name="film")
public class Film implements Serializable {

    @Id
    @SequenceGenerator(
            name="film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "film_sequence"
    )

    @Column(
            name="film_id",
            nullable = false,
            updatable = false
    )
    private Long id ;

    @Column(
            name="titre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String titre;
    @Column(
            name="description",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String description ;

    @ManyToMany (
                    cascade = {CascadeType.MERGE,CascadeType.PERSIST}
                )
    @JoinTable(
            name = "role",
            joinColumns = @JoinColumn(
                    name = "film_id" ,
                    foreignKey = @ForeignKey( name = "role_film_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "acteur_id" ,
                    foreignKey = @ForeignKey( name = "role_acteur_id_fk")
            )

    )
        private List<Acteur> acteurs = new ArrayList<>();


    public Film() {
    }

    public Film(String titre, String description, List<Acteur> acteurs) {
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }

    public Film(Long id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public Long getId() {
        return id;
    }

    public void addActeurToFilm(Acteur acteur){
        if(!acteurs.contains(acteur))
        {
            acteurs.add(acteur);
            acteur.getFilms().add(this);
        }

    }
    public void removeActeurFromFilm(Acteur acteur){
        if(acteurs.contains(acteur))
        {
            acteurs.remove(acteur);
            acteur.getFilms().remove(this);
        }

    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
