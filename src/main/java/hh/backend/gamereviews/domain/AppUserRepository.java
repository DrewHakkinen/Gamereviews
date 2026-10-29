package hh.backend.gamereviews.domain;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsername(String username);
}
