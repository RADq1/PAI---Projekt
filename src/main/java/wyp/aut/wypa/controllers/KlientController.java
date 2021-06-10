package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wyp.aut.wypa.Services.KlientService;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.entities.Wypozyczenie;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.SamochodRepository;
import wyp.aut.wypa.repository.WypozyczanieRepo;

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
    } */

    @GetMapping("/orderCar")
    public String orderCar(Model model){
        model.addAttribute("oddzial",oddzialRepo.findAll());
        return "orderCar";
    }

    @GetMapping("/listCars")
    public String listCars(Model model, Samochod samochod){
        model.addAttribute("samochody",samochodRepository.findAll());
        /*Optional<Samochod> temp = samochodRepository.findById(samochod.getIdSamochod());
        model.addAttribute("auto", samochod);
        System.out.println(temp); */
        return "listCars";
    }
    @GetMapping("/listCars/{id}")
    public String detailedInformation(Model model, @PathVariable Long id)
    {
        model.addAttribute("car",samochodRepository.findById(id).get());
        return "accept";
    }
    /*@PostMapping("/listCars")
    public String blabla(Samochod samochod){

        //System.out.println(temp);
        //model.addAttribute("auto", samochod);
        return "accept";
    } */

    @GetMapping("/complaint")
    public String complaint(){
        return "complaint";
    }

    @GetMapping("/accept")
    public String accept(){
        return "accept";
    }



}
