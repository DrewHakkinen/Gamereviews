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

        model.addAttribute("game", gameRepository.findById(gameId).orElseThrow());
        model.addAttribute("reviews", reviewRepository.findByGame_GameId(gameId));

        return "reviewlist"; // reviewlist.html
    }

    // Tyhjän palautelomakkeen muodostaminen
    @GetMapping(value = "/newreview/{id}")
    public String getNewReviewForm(@PathVariable("id") Integer gameId, Model model) {

        Review review = new Review(); // tyhjä olio
        review.setGame(gameRepository.findById(gameId).orElseThrow()); // pelin id talteen

        model.addAttribute("review", review);
        return "addreview"; // addreview.html
    }

    // palautelomakkeella syötettyjen tietojen vastaanotto ja tallennus
    @PostMapping("/savereview")
    public String saveReview(@ModelAttribute Review review, Model model) {
        reviewRepository.save(review); // SQL INSERT
        return "redirect:/reviewlist/" + review.getGame().getGameId(); // endpoint
    }

    // palautteen poisto
    @RequestMapping(value = "/deletereview/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteReview(@PathVariable("id") Integer reviewId, Model model) {

        Review review = reviewRepository.findById(reviewId).orElseThrow();
        Integer gameId = review.getGame().getGameId();

        reviewRepository.deleteById(reviewId); // SQL DELETE
        return "redirect:/reviewlist/" + gameId; // endpoint
    }

}
