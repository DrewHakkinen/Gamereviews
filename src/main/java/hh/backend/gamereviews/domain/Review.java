package hh.backend.gamereviews.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Review {

    // attribuutit
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    private String graphics;
    private String gameplay;
    private String audio;
    private String pcRequirements;
    private String difficulty;
    private String grind;
    private String story;
    private String gameLength;
    private String pricing;
    private String bugs;
    private String audience;
    private Integer rating;

    @ManyToMany()
    // @JsonIgnoreProperties
    @JsonIgnoreProperties("review")
    private List<Game> games;

    // konstruktorit
    public Review(String graphics, String gameplay, String audio, String pcRequirements, String difficulty,
            String grind, String story, String gameLength, String pricing, String bugs, String audience,
            Integer rating) {
        this.graphics = graphics;
        this.gameplay = gameplay;
        this.audio = audio;
        this.pcRequirements = pcRequirements;
        this.difficulty = difficulty;
        this.grind = grind;
        this.story = story;
        this.gameLength = gameLength;
        this.pricing = pricing;
        this.bugs = bugs;
        this.audience = audience;
        this.rating = rating;
    }

    public Review() {

    }

    // Setterit
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public void setGameplay(String gameplay) {
        this.gameplay = gameplay;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public void setPcRequirements(String pcRequirements) {
        this.pcRequirements = pcRequirements;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setGrind(String grind) {
        this.grind = grind;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setGameLength(String gameLength) {
        this.gameLength = gameLength;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public void setBugs(String bugs) {
        this.bugs = bugs;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    // Getterit
    public Integer getReviewId() {
        return reviewId;
    }

    public String getGraphics() {
        return graphics;
    }

    public String getGameplay() {
        return gameplay;
    }

    public String getAudio() {
        return audio;
    }

    public String getPcRequirements() {
        return pcRequirements;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getGrind() {
        return grind;
    }

    public String getStory() {
        return story;
    }

    public String getGameLength() {
        return gameLength;
    }

    public String getPricing() {
        return pricing;
    }

    public String getBugs() {
        return bugs;
    }

    public String getAudience() {
        return audience;
    }

    public Integer getRating() {
        return rating;
    }

    public List<Game> getGames() {
        return games;
    }

    // toString (ei list:iä mukaan)
    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", graphics=" + graphics + ", gameplay=" + gameplay + ", audio=" + audio
                + ", pcRequirements=" + pcRequirements + ", difficulty=" + difficulty + ", grind=" + grind + ", story="
                + story + ", gameLength=" + gameLength + ", pricing=" + pricing + ", bugs=" + bugs + ", audience="
                + audience + ", rating=" + rating + "]";
    }

}
