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

import hh.backend.gamereviews.domain.Genre;
import hh.backend.gamereviews.domain.GenreRepository;

@Controller
public class GenreController {

    private GenreRepository genreRepository;

    // konstruktori injection
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("genrelist")
    public String showGenres(Model model) {

        // haetaan genret tietokannasta
        model.addAttribute("genres", genreRepository.findAll());

        return "genrelist"; // genrelist.html
    }

    // Tyhjän lomakkeen muodostaminen
    @GetMapping("/newgenre")
    public String getNewcategoryForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "addgenre"; // addgenre.html
    }

    // lomakkeella syötettyjen tietojen vastaanotto ja tallentaminen
    @PostMapping("/savegenre")
    public String saveGenre(@ModelAttribute Genre genre, Model model) {
        genreRepository.save(genre);
        return "redirect:/genrelist"; // endpoint
    }

    // Genren poisto
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteGenre(@PathVariable("id") Integer genreId, Model model) {

        genreRepository.deleteById(genreId); // SQL DELETE
        return "redirect:/genrelist"; // endpoint
    }

}
