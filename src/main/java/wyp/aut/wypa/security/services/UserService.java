package wyp.aut.wypa.security.services;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.repository.KlientRepo;


@Service
public class UserService {

    private KlientRepo klientRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(KlientRepo klientRepo, PasswordEncoder passwordEncoder) {
        this.klientRepo = klientRepo;
        this.passwordEncoder = passwordEncoder;
    }

}
