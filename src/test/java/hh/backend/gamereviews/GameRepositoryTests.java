package hh.backend.gamereviews;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        List<Game> games = gameRepository.findByTitle("GTA IV");
        assertThat(games).hasSize(1);
        assertThat(games.get(0).getDeveloper()).isEqualTo("Rockstar");
    }

    @Test
    public void createNewGame() {
        Game game = new Game("Creature Kitchen", "The Rat Zone", 7.79, 2026, null);
        gameRepository.save(game);

        assertThat(game.getGameId()).isNotNull();
    }

    @Test
    public void deleteGame() {
        Game game = new Game("Creature Kitchen", "The Rat Zone", 7.79, 2026, null);
        gameRepository.save(game);

        gameRepository.delete(game);

        assertThat(gameRepository.findByTitle("Creature Kitchen")).isEmpty();
    }

}
