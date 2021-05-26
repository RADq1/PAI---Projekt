package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyp.aut.wypa.Services.KlientService;


@Controller
public class MainController {
    //podpiecie serwisu do controllera
    private final KlientService klientService;

    @Autowired
    public MainController(KlientService klientService) {
        this.klientService = klientService;
    }

    //strona główna
    @GetMapping("/")
    public String get(){
        return "home";
    }


    //TODO
    //zapytanie, czy klient stworzył konto, jeśli nie, to przycisk to przekierowania do rejestracji
    //analogicznie jesli ma konto, link do logowania

    //strona rejestracji
    @GetMapping ("/register")
    public String register()
    {return "register";}
    //panel klienta
    @GetMapping ("/clientPanel1")
    @ResponseBody
    public String clientPanel1()
    {return "clientPanel";}
    //logowanie
    @GetMapping ("/logins")
    public String logins()
    {return "logins";}

    @GetMapping("/clientPanel")
    public String clientPanel()
    {
        return "clientPanel";
    }
    @GetMapping("/employeePanel")
    public String employeePanel()
    {
        return "employeePanel";
    }


}
