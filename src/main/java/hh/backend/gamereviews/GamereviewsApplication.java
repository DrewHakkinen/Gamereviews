package hh.backend.gamereviews;

import hh.backend.gamereviews.domain.AppUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.gamereviews.domain.AppUser;
import hh.backend.gamereviews.domain.Game;
import hh.backend.gamereviews.domain.GameRepository;
import hh.backend.gamereviews.domain.Genre;
import hh.backend.gamereviews.domain.GenreRepository;
import hh.backend.gamereviews.domain.Review;
import hh.backend.gamereviews.domain.ReviewRepository;

@SpringBootApplication
public class GamereviewsApplication {

	private static final Logger log = LoggerFactory.getLogger(GamereviewsApplication.class);

	private final AppUserRepository appUserRepository;

	GamereviewsApplication(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GamereviewsApplication.class, args);
	}

	// Testidataa tietokantaan
	@Bean
	public CommandLineRunner demo(GameRepository gameRepository, GenreRepository genreRepository,
			ReviewRepository reviewRepository) {
		return (args) -> {
			log.info("Save some genres");
			// Genret
			genreRepository.save(new Genre("Action"));
			genreRepository.save(new Genre("Adventure"));
			genreRepository.save(new Genre("Simulation"));
			genreRepository.save(new Genre("Horror"));

			log.info("Save some sample games");
			// Pelit
			Game game1 = new Game("Mafia II", "2K Czech", 29.99, 2010, genreRepository.findByName("Action").get(0));
			gameRepository.save(game1); // SQL INSERT
			Game game2 = new Game("Stardew Valley", "Concerned Ape", 13.99, 2016,
					genreRepository.findByName("Adventure").get(0));
			gameRepository.save(game2); // SQL INSERT
			Game game3 = new Game("Inscryption", "Daniel Mullins Games", 19.99, 2021,
					genreRepository.findByName("Horror").get(0));
			gameRepository.save(game3); // SQL INSERT
			Game game4 = new Game("GTA IV", "Rockstar", 24.50, 2009, genreRepository.findByName("Action").get(0));
			gameRepository.save(game4);

			log.info("Save some sample reviews");
			// Palautteet
			Review review1 = new Review("Beautiful", "Good", "Very good", "Potato", "Easy to learn / hard to master",
					"Nothing to grind", "Lovely", "Not bad duration (12-20 hours)", "Worth the price",
					"Can get annoying", "Adults", 10, gameRepository.findByTitle("Mafia II").get(0));
			reviewRepository.save(review1);
			Review review2 = new Review("Good", "Good", "Very good", "Potato", "Easy to learn / hard to master",
					"You'll need a second life for grinding", "Average", "Endless", "Worth the price",
					"Never heard of", "All", 10, gameRepository.findByTitle("Stardew Valley").get(0));
			reviewRepository.save(review2);
			Review review3 = new Review("Decent", "Very good", "Not too bad", "Potato", "Significant brain usage",
					"Nothing to grind", "Good", "Long (20-50 hours)", "Worth the price",
					"Never heard of", "All", 7, gameRepository.findByTitle("Inscryption").get(0));
			reviewRepository.save(review3);
			Review review4 = new Review("Decent", "Good", "Very good", "Decent", "Easy",
					"Average grind level", "Lovely", "Long (20-50 hours)", "If it's on sale",
					"Minor bugs", "Adults", 8, gameRepository.findByTitle("GTA IV").get(0));
			reviewRepository.save(review4);

			log.info("Save sample users");
			// Käyttäjät
			AppUser user1 = new AppUser("Maija", "$2a$10$cmAb.uXySswCjKy.gSFc2eNtKXI6wJrNHY9M9qPfxcttjVCGmpvfi",
					"USER");
			appUserRepository.save(user1);
			AppUser user2 = new AppUser("Matti", "$2a$10$/iNW96f6LHQUx3Z2G6OG.OOWSpl4YDkcUbkxg.fpCSVSCxuCIpKFC",
					"ADMIN");
			appUserRepository.save(user2);

			log.info("Fetch all the genres");
			for (Genre genre : genreRepository.findAll()) {
				log.info(genre.toString());
			}

			log.info("Fetch all the games");
			for (Game game : gameRepository.findAll()) {
				log.info(game.toString());
			}

			log.info("Fetch all the reviews");
			for (Review review : reviewRepository.findAll()) {
				log.info(review.toString());
			}
		};
	}

}
