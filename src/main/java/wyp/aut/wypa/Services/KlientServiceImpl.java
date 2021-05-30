package wyp.aut.wypa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Klient;
<<<<<<< Updated upstream
=======
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.entities.Token;
>>>>>>> Stashed changes
import wyp.aut.wypa.repository.KlientRepo;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class KlientServiceImpl implements KlientService {
    //połączenie serwisu z klientRepo
    private final KlientRepo klientRepo;
    @Autowired
    public KlientServiceImpl(KlientRepo klientRepo) {
        this.klientRepo = klientRepo;
    }
    //Override uzywamy, bo juz istnieje
    //W serwisie Impl (jak sama nazwa wskazuje - implementujemy nasz serwis)
    @Override
    public void addKlient(Klient klient) {
        //System.out.println("test"); //testowy print, czy dziala
        klientRepo.save(klient); // zapisanie klienta


    }
    @Override
    public Boolean checkLogin(String login){
        //zwraca true, jak podany użytkownik istnieje.
        return klientRepo.existsByLogin(login);
    }


    @Override
    public Boolean checkPassword(String login, String haslo){

       Optional<Klient> klient = klientRepo.findByLogin(login);
        /*System.out.println(haslo); //sa
        System.out.println(klient.get().getHaslo()); //sa */
        String hasloKlient = klient.get().getHaslo();

        //Porównywanie stringów w Javie (zamiast == -> equals())
        if(hasloKlient.equals(haslo)){
            return true;
        } else {
            return false;
        }

    }




<<<<<<< Updated upstream
=======
    }


    @Override
    public void orderCar(Samochod samochod)
    {
        
    }

>>>>>>> Stashed changes
}
