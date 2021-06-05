package wyp.aut.wypa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.entities.Token;
import wyp.aut.wypa.repository.KlientRepo;
import wyp.aut.wypa.repository.TokenRepo;

import javax.mail.MessagingException;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
public class KlientServiceImpl implements KlientService {
    //połączenie serwisu z klientRepo
    private KlientRepo klientRepo;
    private PasswordEncoder passwordEncoder;
    private TokenRepo tokenRepo;
    private MailService mailService;

    public KlientServiceImpl(KlientRepo klientRepo, PasswordEncoder passwordEncoder, TokenRepo tokenRepo, MailService mailService) {
        this.klientRepo = klientRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
    }

    @Override
    public void addKlient(Klient klient) {
        klient.setPassword(passwordEncoder.encode(klient.getPassword()));
        klient.setRole("ROLE_USER");
        klientRepo.save(klient); // zapisanie klienta
        sendToken(klient);

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


    @Override
    public void sendToken(Klient klient) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setKlient(klient);
        tokenRepo.save(token);
        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(klient.getEmail(), "Potwierdz założenie konta w naszym serwisie", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
