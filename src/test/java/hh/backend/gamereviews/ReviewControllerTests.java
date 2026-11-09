package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.gamereviews.web.ReviewController;

@SpringBootTest
public class ReviewControllerTests {

    @Autowired
    private ReviewController reviewController;

    @Test
    public void contextLoads() {
        assertThat(reviewController).isNotNull();
    }

}
