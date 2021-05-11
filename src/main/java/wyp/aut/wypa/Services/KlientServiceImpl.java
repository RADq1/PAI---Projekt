package wyp.aut.wypa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.repository.KlientRepo;

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
}
