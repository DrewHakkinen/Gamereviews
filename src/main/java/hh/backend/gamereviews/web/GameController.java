package hh.backend.gamereviews.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.backend.gamereviews.domain.Game;
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

    @GetMapping("/index")
    public String getGames(Model model) {

        return "index"; // index.html
    }

    // pelilistaus
    @GetMapping("/gamelist")
    public String showGames(Model model) {

        // Haetaan pelit tietokannasta findAll -> SQL SELECT
        model.addAttribute("games", gameRepository.findAll());

        return "gamelist"; // gamelist.html
    }

    // Tyhjän pelilomakkeen muodostaminen
    @GetMapping(value = "/newgame")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getNewGameForm(Model model) {

        model.addAttribute("game", new Game()); // tyhjä peli-olio
        model.addAttribute("genres", genreRepository.findAll());
        return "addgame"; // addgame.html
    }

    // pelilomakkeella syötettyjen tietojen vastaanotto ja tallennus
    @PostMapping("/savegame")
    public String saveGame(@ModelAttribute Game game, Model model) {
        gameRepository.save(game); // SQL INSERT
        return "redirect:/gamelist"; // endpoint
    }

    // Pelin poisto
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteGame(@PathVariable("id") Integer gameId, Model model) {

        gameRepository.deleteById(gameId); // SQL DELETE
        return "redirect:/gamelist"; // endpoint
    }

    // Pelin editointi
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGame(@PathVariable("id") Integer gameId, Model model) {

        model.addAttribute("game", gameRepository.findById(gameId).get());
        model.addAttribute("genres", genreRepository.findAll());
        return "editgame"; // editgame.html
    }

}
