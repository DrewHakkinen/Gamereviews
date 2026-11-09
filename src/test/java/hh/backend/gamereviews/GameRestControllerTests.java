package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.gamereviews.web.GameRestController;

@SpringBootTest
public class GameRestControllerTests {

    @Autowired
    private GameRestController gameRestController;

    @Test
    public void contextLoads() {
        assertThat(gameRestController).isNotNull();
    }

}
