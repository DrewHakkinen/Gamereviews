package hh.backend.gamereviews.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Genre {

    // attribuutit
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    private String name;

    // @JsonIgnore tänne
    private List<Game> games;

    // konstruktorit
    public Genre(String name) {
        super();
        this.name = name;
    }

    public Genre() {
    }

    // Setterit
    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    // Getterit
    public int getGenreId() {
        return genreId;
    }

    public String getName() {
        return name;
    }

    public List<Game> getGames() {
        return games;
    }

    // toString
    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", name=" + name + "]";
    }

}
