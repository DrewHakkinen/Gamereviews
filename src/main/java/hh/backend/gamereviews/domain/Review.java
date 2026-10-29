package hh.backend.gamereviews.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    // attribuutit
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    private String Content;
    private int rating;

    // @JsonIgnoreProperties
    // TODO: table connections

    // konstruktorit

    // Setterit

    // Getterit

}
