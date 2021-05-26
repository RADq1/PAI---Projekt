package wyp.aut.wypa;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.repository.KlientRepo;

@Configuration
public class Start {


    public Start(KlientRepo klientRepo, PasswordEncoder passwordEncoder) {


    }
}
