package hh.backend.gamereviews.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

    // Crudreposta periytyy save, findAll, findId ja deleteById
    List<Review> findByGame_GameId(Integer gameId);

    List<Review> findByAudience(String audience);

    List<Review> findByDifficulty(String difficulty);

    List<Review> findByPcRequirements(String pcRequirements);

    List<Review> findByPricing(String pricing);

}
