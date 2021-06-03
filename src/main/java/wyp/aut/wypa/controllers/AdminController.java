package wyp.aut.wypa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.repository.SamochodRepository;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    SamochodRepository samochodRepository;



    @GetMapping("/adminPanel")
    public String panelAdmin()
    {
        return "adminPanel";
    }

    @GetMapping("/auta")
    @ResponseBody
    public List<Samochod> allCars()
    {
        return samochodRepository.findAll();
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
