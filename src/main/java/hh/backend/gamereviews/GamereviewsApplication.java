package hh.backend.gamereviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.gamereviews.domain.Game;
import hh.backend.gamereviews.domain.GameRepository;
import hh.backend.gamereviews.domain.Genre;
import hh.backend.gamereviews.domain.GenreRepository;

@SpringBootApplication
public class GamereviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamereviewsApplication.class, args);
	}

	// Testidataa tietokantaan
	@Bean
	public CommandLineRunner demo(GameRepository gameRepository, GenreRepository genreRepository) {
		return (args) -> {
			genreRepository.save(new Genre("Action"));
			genreRepository.save(new Genre("Adventure"));
			genreRepository.save(new Genre("Simulation"));
			genreRepository.save(new Genre("Horror"));

			Game game1 = new Game("Mafia II", "2K Czech", 29.99, 2011, genreRepository.findByName("Action").get(0));
			gameRepository.save(game1); // SQL INSERT
			Game game2 = new Game("Stardew Valley", "Concerned Ape", 13.99, 2016,
					genreRepository.findByName("Adventure").get(0));
			gameRepository.save(game2); // SQL INSERT
			Game game3 = new Game("Inscryption", "Daniel Mullins Games", 19.99, 2021,
					genreRepository.findByName("Horror").get(0));
			gameRepository.save(game3); // SQL INSERT
			Game game4 = new Game("GTA IV", "Rockstar", 24.50, 2009, genreRepository.findByName("Action").get(0));
			gameRepository.save(game4);
		};
	}

}
