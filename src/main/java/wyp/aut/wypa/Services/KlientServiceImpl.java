package wyp.aut.wypa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.repository.KlientRepo;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class KlientServiceImpl implements KlientService {
    //połączenie serwisu z klientRepo
    private KlientRepo klientRepo;
    private PasswordEncoder passwordEncoder;

    public KlientServiceImpl(KlientRepo klientRepo, PasswordEncoder passwordEncoder) {
        this.klientRepo = klientRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addKlient(Klient klient) {
        klient.setPassword(passwordEncoder.encode(klient.getPassword()));
        klient.setRole("ROLE_USER");
        klientRepo.save(klient); // zapisanie klienta


    }
    @Override
    public Boolean checkLogin(String login){
        //zwraca true, jak podany użytkownik istnieje.
        return klientRepo.existsByUsername(login);
    }


    @Override
    public Boolean checkPassword(String login, String haslo){

       Optional<Klient> klient = klientRepo.findByUsername(login);
        /*System.out.println(haslo); //sa
        System.out.println(klient.get().getHaslo()); //sa */
        String hasloKlient = klient.get().getPassword();

        //Porównywanie stringów w Javie (zamiast == -> equals())
        if(hasloKlient.equals(haslo)){
            return true;
        } else {
            return false;
        }

    }




}
