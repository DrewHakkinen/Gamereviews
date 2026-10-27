package hh.backend.gamereviews.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    // CRUDRepositorypalveluista periytyy save, findAll, findId ja deleteById
    List<Genre> findByName(String name);

}
