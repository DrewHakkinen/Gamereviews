package hh.backend.gamereviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.gamereviews.domain.AppUser;
import hh.backend.gamereviews.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTests {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void createNewUser() {
        AppUser appuser = new AppUser("Pekka", "hei", "USER");
        appUserRepository.save(appuser);
        assertThat(appuser.getId()).isNotNull();

    }

    @Test
    public void searchUserByUsername() {
        AppUser user = new AppUser("Pekka", "hei", "USER");
        appUserRepository.save(user);

        AppUser appuser = appUserRepository.findByUsername("Pekka");

        assertThat(appuser).isNotNull();
        assertThat(appuser.getRole()).isEqualTo("USER");
    }

    @Test
    public void DeleteUser() {
        AppUser appuser = new AppUser("Pekka", "hei", "USER");
        appUserRepository.save(appuser);

        appUserRepository.delete(appuser);

        assertThat(appUserRepository.findByUsername("Pekka")).isNull();
    }

}
