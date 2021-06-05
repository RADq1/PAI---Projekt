package wyp.aut.wypa;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.entities.Pracownik;
import wyp.aut.wypa.repository.KlientRepo;

@Configuration
public class Start {


    public Start(KlientRepo klientRepo, PasswordEncoder passwordEncoder) {
        //odkomentowac zeby dodac na sztywno klienta i pracownika

        //TODO zrobic usuwanie danych z bazy danych prawwidłowo, teraz mozna jedynie recznie
    /*    Klient klient = new Klient();
        klient.setRole("ROLE_USER");
        klient.setPassword(passwordEncoder.encode("haslo"));
        klient.setUsername("User");
        klientRepo.save(klient);

        Klient klient2 = new Klient();
        klient2.setRole("ROLE_EMPLOYEE");
        klient2.setPassword(passwordEncoder.encode("haslo"));
        klient2.setUsername("Employee");
        klientRepo.save(klient2);*/
    }
}
