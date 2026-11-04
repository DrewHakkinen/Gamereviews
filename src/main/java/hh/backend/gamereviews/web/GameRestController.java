package hh.backend.gamereviews.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.backend.gamereviews.domain.Game;
import hh.backend.gamereviews.domain.GameRepository;
import hh.backend.gamereviews.domain.Genre;
import hh.backend.gamereviews.domain.GenreRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class GameRestController {

    private GameRepository gameRepository;
    private GenreRepository genreRepository;

    // konstruktori injection
    public GameRestController(GameRepository gameRepository, GenreRepository genreRepository) {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
    }

    // RESTful service getting all games
    // Muunnetaan JSON-pelilistaksi
    // lähetetään web-selaimelle vastauksena
    @GetMapping("/getgames")
    public @ResponseBody List<Game> findAllGamesRest() {
        return (List<Game>) gameRepository.findAll();
    }

    // Restful service game by id
    @GetMapping("/games/{id}")
    public @ResponseBody Optional<Game> getOneGameRest(@PathVariable(name = "id") Integer gameId) {
        return gameRepository.findById(gameId);
    }

    @GetMapping("/getGenres")
    public @ResponseBody List<Genre> findAllGenresRest() {
        return (List<Genre>) genreRepository.findAll();
    }

}
