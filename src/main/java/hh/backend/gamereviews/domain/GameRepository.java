package hh.backend.gamereviews.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

    // CRUDRepositorypalveluista periytyy save, findAll, findId ja deleteById
    List<Game> findByTitle(String title);

    List<Game> findByDeveloper(String developer);

    List<Game> findByGenre(Genre genre);

}
