package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.gamereviews.web.GameController;

@SpringBootTest
public class GameControllerTests {

    @Autowired
    private GameController gameController;

    @Test
    public void contextLoads() {
        assertThat(gameController).isNotNull();
    }

}
