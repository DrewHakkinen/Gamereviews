package hh.backend.gamereviews.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Game {

    // attribuutit
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // uusi id arvo generoituu uudelle tietoriville
    private Integer gameId;

    private String title;
    private String developer;
    private Double price;
    private Integer publicationYear;

    @ManyToOne
    // @JsonIgnoreProperties
    @JsonIgnoreProperties("getgames")
    @JoinColumn(name = "genreid")
    private Genre genre;

    // konstruktorit
    public Game(String title, String developer, Double price, Integer publicationYear, Genre genre) {
        super();
        this.title = title;
        this.developer = developer;
        this.price = price;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public Game() {

    }

    // setterit
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Getterit
    public Integer getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Genre getGenre() {
        return genre;
    }

    // toString
    @Override
    public String toString() {
        return "Game [gameId=" + gameId + ", title=" + title + ", developer=" + developer + ", price=" + price
                + ", publicationYear=" + publicationYear + ", genre=" + genre + "]";
    }
}
