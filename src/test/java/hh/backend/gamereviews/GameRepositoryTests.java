package hh.backend.gamereviews;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.gamereviews.domain.Game;
import hh.backend.gamereviews.domain.GameRepository;

@DataJpaTest
public class GameRepositoryTests {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void findByTitleShouldReturnGame() {
        Game game = new Game("GTA IV", "Rockstar", 15.50, 2009, null);
        gameRepository.save(game);

        List<Game> games = gameRepository.findByTitle(null);
    }

}
