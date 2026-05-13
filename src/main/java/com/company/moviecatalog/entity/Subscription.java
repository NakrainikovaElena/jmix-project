package com.company.moviecatalog.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "SUBSCRIPTION", indexes = {
        @Index(name = "IDX_SUBSCRIPTION_FILM", columnList = "FILM_ID"),
        @Index(name = "IDX_SUBSCRIPTION_USER", columnList = "USER_ID")
})
@Entity
public class Subscription {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VALIDITY_PERIOD")
    private String validity_period;

    @JoinColumn(name = "FILM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;


    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String getValidity_period() {
        return validity_period;
    }

    public void setValidity_period(String validity_period) {
        this.validity_period = validity_period;
    }

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}