package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wyp.aut.wypa.Services.KlientService;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.entities.Token;
import wyp.aut.wypa.repository.KlientRepo;
import wyp.aut.wypa.repository.TokenRepo;


@Controller
public class MainController {
    //podpiecie serwisu do controllera
    private KlientService klientService;
    private KlientRepo klientRepo;
    private TokenRepo tokenRepo;

    public MainController(KlientService klientService, KlientRepo klientRepo, TokenRepo tokenRepo) {
        this.klientService = klientService;
        this.klientRepo = klientRepo;
        this.tokenRepo = tokenRepo;
    }

    //strona główna
    @GetMapping("/")
    public String get() {
        return "home";
    }

    //strona główna
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/register")
    public String register(Klient klient) {
        klientService.addKlient(klient);
        return "home";
    }

    //strona rejestracji
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Klient());
        return "register";
    }

    //panel klienta
    @GetMapping("/clientPanel1")
    @ResponseBody
    public String clientPanel1() {
        return "clientPanel";
    }


    @GetMapping("/clientPanel")
    public String clientPanel() {
        return "clientPanel";
    }

    @GetMapping("/employeePanel")
    public String employeePanel() {
        return "employeePanel";
    }

    @GetMapping("/token")
    public String singup(@RequestParam String value) {
        Token byValue = tokenRepo.findByValue(value);
        Klient appUser = byValue.getKlient();
        appUser.setEnabled(true);
        klientRepo.save(appUser);
        return "home";
    }

}
