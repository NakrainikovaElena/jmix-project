package com.company.moviecatalog.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "FILM")
@Entity
public class Film {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "RELEASE_YEAR")
    private Integer release_year;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "RATING", precision = 3, scale = 1)
    private BigDecimal rating;

    @JoinTable(name = "FILM_ACTOR_LINK",
            joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Actor> actors;

    @JoinTable(name = "FILM_GENRE_LINK",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    @ManyToMany
    private List<Genre> genres;

    @JoinTable(name = "FILM_DIRECTOR_LINK",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "DIRECTOR_ID"))
    @ManyToMany
    private List<Director> directors;

    @OneToMany(mappedBy = "film")
    private List<Feedback> feedback;

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
