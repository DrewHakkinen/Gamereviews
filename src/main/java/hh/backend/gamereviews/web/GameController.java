package hh.backend.gamereviews.web;

import org.springframework.stereotype.Controller;

import hh.backend.gamereviews.domain.GameRepository;
import hh.backend.gamereviews.domain.GenreRepository;

@Controller
public class GameController {

    private GameRepository gameRepository;
    private GenreRepository genreRepository;

    // konstruktori injection
    public GameController(GameRepository gameRepository, GenreRepository genreRepository) {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
    }

}
