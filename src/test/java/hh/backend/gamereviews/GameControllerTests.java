package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameControllerTests {

    @Autowired
    private GameControllerTests gameController;

    @Test
    public void contextLoads() {
        assertThat(gameController).isNotNull();
    }

}
