package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wyp.aut.wypa.Services.KlientService;
import wyp.aut.wypa.entities.Klient;

@Controller
public class KlientController {
    //połączenie serwisu z controllerem
    private final KlientService klientService;
    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    //RequestMapping do rejestracji klienta
    public String errorRegister;
    @RequestMapping("/add")
    public String addKlient(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "haslo") String haslo,
            @RequestParam(name = "imie") String imie,
            @RequestParam(name = "nazwisko") String nazwisko,
            @RequestParam(name = "nrTel") String nrTel,
            @RequestParam(name = "PESEL") String PESEL,
            Model model
    )
    {
        //zabezpieczenia przed błędnymi danymi
        if(login.length() != 0 & haslo.length() != 0 & imie.length() != 0 & nazwisko.length() != 0 & nrTel.length() != 0 & PESEL.length() != 0)
        {
            System.out.println("Dane nie są nullami");
            if(login.length() <= 15 & PESEL.length() <= 11 & nrTel.length() <= 9 & haslo.length() <= 30)
            {
                //odwolanie do funkcji w serwisie "registerKlient" z parametrami, ktore zostaly podane w HTML'u, za pomocą thymeleaf
                klientService.addKlient(new Klient(login, haslo, imie, nazwisko, nrTel, PESEL));
                //odwolanie sie do imienia, potrzebne do wyswietlenia np. Witaj, ${imie}
                model.addAttribute("imie", imie);
                return "clientPanel";
            } else {
                errorRegister = "Sprawdź poprawną długość danych!";
                model.addAttribute("errorRegister", errorRegister);
                return "errorRegister";
            }
        } else
        {
            errorRegister = "Niektóre pola są puste, wypełnij je wszystkie!";
            model.addAttribute("errorRegister", errorRegister);
            return "errorRegister";
        }
    }


    //TODO logowanie
}
