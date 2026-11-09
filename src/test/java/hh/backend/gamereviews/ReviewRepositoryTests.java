package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.gamereviews.domain.Review;
import hh.backend.gamereviews.domain.ReviewRepository;

@DataJpaTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void findByRatingShouldReturnReview() {
        List<Review> reviews = reviewRepository.findByAudience("Adults");
        assertThat(reviews).hasSize(1);
        assertThat(reviews.get(0).getPricing()).isEqualTo("Worth the price");
    }

    @Test
    public void createNewReview() {
        Review review = new Review(
                "Good", "It's just gameplay", "Very good", "Potato",
                "Significant brain usage", "Average grind level",
                "Some lore", "Endless", "It's free!", "Never heard of", "All", 8, null);
        reviewRepository.save(review);

        assertThat(review.getReviewId()).isNotNull();
    }

    @Test
    public void deleteReview() {
        Review review = new Review(
                "Good", "It's just gameplay", "Very good", "Potato",
                "Significant brain usage", "Average grind level",
                "Some lore", "Endless", "It's free!", "Never heard of", "All", 8, null);
        reviewRepository.save(review);

        reviewRepository.delete(review);

        assertThat(reviewRepository.findByDifficulty("Significant brain usage")).isEmpty();
    }

}
