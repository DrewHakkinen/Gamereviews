package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.gamereviews.web.GenreController;

@SpringBootTest
public class GenreControllerTests {

    @Autowired
    private GenreController genreController;

    @Test
    public void contextLoads() {
        assertThat(genreController).isNotNull();
    }

}
