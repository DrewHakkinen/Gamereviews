package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.gamereviews.domain.Genre;
import hh.backend.gamereviews.domain.GenreRepository;

@DataJpaTest
public class GenreRepositoryTests {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void createNewGenre() {
        Genre genre = new Genre("Farming");
        genreRepository.save(genre);

        assertThat(genre.getGenreId()).isNotNull();
    }

    @Test
    public void findByNameShouldReturnGenre() {
        List<Genre> genres = genreRepository.findByName("Horror");

        assertThat(genres).hasSize(1);
        assertThat(genres.get(0).getName()).isEqualTo("Horror");

    }

    @Test
    public void deleteGenre() {
        Genre genre = new Genre("Farming");
        genreRepository.save(genre);

        genreRepository.delete(genre);

        assertThat(genreRepository.findByName("Farming")).isEmpty();
    }

}
