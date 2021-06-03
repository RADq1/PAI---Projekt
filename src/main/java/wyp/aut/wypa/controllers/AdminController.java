package wyp.aut.wypa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.SamochodRepository;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    SamochodRepository samochodRepository;
    @Autowired
    OddzialRepo oddzialRepo;


    @GetMapping("/adminPanel")
    public String panelAdmin()
    {
        return "adminPanel";
    }

    @GetMapping("/auta")
    public String allCars(Model model)
    {
        model.addAttribute("samochody",samochodRepository.findAll());
        return "AllCars";
    }
    @GetMapping("/auta/{id}")
    public String detailedInformation(Model model, @PathVariable Long id)
    {
        model.addAttribute("car",samochodRepository.findById(id).get());
        return "carInfo";
    }


    @GetMapping("/pracownicy")
    @ResponseBody
    public String allEmployee()
    {
        return "pracownicy";
    }

    @GetMapping("/statystyki")
    @ResponseBody
    public String statistick()
    {
        return "statystyki";
    }

    @GetMapping("/przychody")
    @ResponseBody
    public String stonks()
    {
        return "przychody";
    }

    @GetMapping("/adminPanel/{oddzialID}}")
    @ResponseBody
    public String AllCarsFactory(@PathVariable String oddzialID)
    {
        return oddzialID;
    }




}
