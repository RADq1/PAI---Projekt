package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wyp.aut.wypa.Services.KlientService;
import wyp.aut.wypa.entities.*;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.SamochodRepository;
import wyp.aut.wypa.repository.WypozyczanieRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class KlientController {
    //połączenie serwisu z controllerem
    private final KlientService klientService;
    private WypozyczanieRepo wypozyczanieRepo;
    private OddzialRepo oddzialRepo;
    private SamochodRepository samochodRepository;
    @Autowired
    public KlientController(KlientService klientService, WypozyczanieRepo wypozyczanieRepo, OddzialRepo oddzialRepo, SamochodRepository samochodRepository) {
        this.wypozyczanieRepo = wypozyczanieRepo;
        this.klientService = klientService;
        this.oddzialRepo = oddzialRepo;
        this.samochodRepository = samochodRepository;
    }
  /*  @EventListener(ApplicationReadyEvent.class)
    public void addOddzial(){
        oddzialRepo.save(new Oddzial("Bydgoszcz"));
        oddzialRepo.save(new Oddzial("Toruń"));
        oddzialRepo.save(new Oddzial("Gdańsk"));
    }

    @GetMapping("/orderCar")
    public String orderCar(Model model){
        model.addAttribute("oddzial",oddzialRepo.findAll());
        return "orderCar";
    }*/

    @GetMapping("/listCars")
    public String listCars(Model model, Samochod samochod){
        model.addAttribute("samochody",samochodRepository.findAll());
        /*Optional<Samochod> temp = samochodRepository.findById(samochod.getIdSamochod());
        model.addAttribute("auto", samochod);
        System.out.println(temp); */
        return "listCars";
    }

    @GetMapping("/listCars/{id}")
    public String detailedInformation(Model model, @PathVariable Long id, Wypozyczenie wypozyczenie)
    {
        model.addAttribute("car",samochodRepository.findById(id).get());
        model.addAttribute("wypozyczenie", wypozyczenie);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Klient klient = (Klient)auth.getPrincipal();
        model.addAttribute("klient", klient);
        return "accept";
    }

    @PostMapping("/accept/{id}")
    public String wypozycz(Model model, Wypozyczenie wypozyczenie){
        model.addAttribute("wypozyczenie", wypozyczenie);
        System.out.println(wypozyczenie.getDataOddania());
        System.out.println(wypozyczenie.getDataWypożyczenia());
        wypozyczanieRepo.save(wypozyczenie);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Klient klient = (Klient)auth.getPrincipal();
        model.addAttribute("test", klient);


        return "success";
    }

    @GetMapping("/myCars")
    public String complaint(Model model){
        model.addAttribute("samochody",samochodRepository.findAll());
        model.addAttribute("wypozyczenia",wypozyczanieRepo.findAll());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Klient klient = (Klient)auth.getPrincipal();
        model.addAttribute("klient", klient);

        return "complaint";
    }

    @GetMapping("/accept")
    public String accept()
    {
        return "accept";
    }






}
