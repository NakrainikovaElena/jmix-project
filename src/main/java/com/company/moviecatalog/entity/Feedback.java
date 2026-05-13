package com.company.moviecatalog.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "FEEDBACK", indexes = {
        @Index(name = "IDX_FEEDBACK_FILM", columnList = "FILM_ID"),
        @Index(name = "IDX_FEEDBACK_USER", columnList = "USER_ID")
})
@Entity
public class Feedback {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FEEDBACK")
    private String feedback;

    @JoinColumn(name = "FILM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}