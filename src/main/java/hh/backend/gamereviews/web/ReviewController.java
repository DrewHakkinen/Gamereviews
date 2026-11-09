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

import hh.backend.gamereviews.domain.GameRepository;
import hh.backend.gamereviews.domain.Review;
import hh.backend.gamereviews.domain.ReviewRepository;

@Controller
public class ReviewController {

    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;

    // konstruktori injection
    public ReviewController(ReviewRepository reviewRepository, GameRepository gameRepository) {
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
    }

    // palautelistaus
    @GetMapping("/reviewlist/{id}")
    public String showReviews(@PathVariable("id") Integer gameId, Model model) {

        model.addAttribute("reviews", reviewRepository.findByGame_GameId(gameId));

        return "reviewlist"; // reviewlist.html
    }

    // Tyhjän palautelomakkeen muodostaminen
    @GetMapping(value = "/newreview")
    public String getNewReviewForm(Model model) {

        model.addAttribute("review", new Review()); // tyhjä palaute-olio
        model.addAttribute("games", gameRepository.findAll());
        return "addreview"; // addreview.html
    }

    // palautelomakkeella syötettyjen tietojen vastaanotto ja tallennus
    @PostMapping("/savereview")
    public String saveReview(@ModelAttribute Review review, Model model) {
        reviewRepository.save(review); // SQL INSERT
        return "redirect:/reviewlist"; // endpoint
    }

    // pelikohtaisten palautteiden näyttö
    // @RequestMapping(value = "/review/{id}", method = RequestMethod.GET)
    // public String showCertainReviews(@PathVariable("id") Integer gameId, Model
    // model) {

    // model.addAttribute("game", gameRepository.findById(gameId).get());
    // model.addAttribute("reviews", reviewRepository.findAll());
    // return "reviewlist"; // reviewlist.html
    // }

    // palautteen poisto
    @RequestMapping(value = "/deletereview/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteReview(@PathVariable("id") Integer reviewId, Model model) {

        reviewRepository.deleteById(reviewId); // SQL DELETE
        return "redirect:/reviewlist"; // endpoint
    }

}
