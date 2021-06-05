package wyp.aut.wypa.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.repository.KlientRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private KlientRepo klientRepo;

    public UserDetailsServiceImpl(KlientRepo klientRepo) {
        this.klientRepo = klientRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return klientRepo.findByUsername(username).get();
    }
}
