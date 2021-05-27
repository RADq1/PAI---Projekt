package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyp.aut.wypa.Services.KlientService;
import wyp.aut.wypa.entities.Klient;


@Controller
public class MainController {
    //podpiecie serwisu do controllera
    private KlientService klientService;
    private PasswordEncoder passwordEncoder;

    public MainController(KlientService klientService, PasswordEncoder passwordEncoder) {
        this.klientService = klientService;
        this.passwordEncoder = passwordEncoder;
    }

    //strona główna
    @GetMapping("/")
    public String get() {
        return "home";
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


}
