package wyp.aut.wypa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wyp.aut.wypa.Services.KlientService;
import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.WypozyczanieRepo;

@Controller
public class KlientController {
    //połączenie serwisu z controllerem
    private final KlientService klientService;
    private WypozyczanieRepo wypozyczanieRepo;
    private OddzialRepo oddzialRepo;
    @Autowired
    public KlientController(KlientService klientService, WypozyczanieRepo wypozyczanieRepo, OddzialRepo oddzialRepo) {
        this.wypozyczanieRepo = wypozyczanieRepo;
        this.klientService = klientService;
        this.oddzialRepo = oddzialRepo;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void addOddzial(){
        oddzialRepo.save(new Oddzial("Bydgoszcz"));
        oddzialRepo.save(new Oddzial("Toruń"));
        oddzialRepo.save(new Oddzial("Gdańsk"));
    }

    @GetMapping("/orderCar")
    public String orderCar(Model model){
        model.addAttribute("oddzial",oddzialRepo.findAll());
        return "orderCar";
    }




}
