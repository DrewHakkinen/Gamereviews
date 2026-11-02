package hh.backend.gamereviews.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.backend.gamereviews.domain.AppUser;
import hh.backend.gamereviews.domain.AppUserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public UserDetailService(AppUserRepository userRepository) {
        this.appUserRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = appUserRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));

        return user;
    }

}
