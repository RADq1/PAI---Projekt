package wyp.aut.wypa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;
import wyp.aut.wypa.Services.SamochodService;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.SamochodRepository;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class AdminController {

    @Autowired
    SamochodRepository samochodRepository;
    @Autowired
    OddzialRepo oddzialRepo;
    @Autowired
    SamochodService samochodService;


    @GetMapping("/adminPanel")
    public String panelAdmin()
    {
        return "/admin/allFactory/adminPanel";
    }

    @GetMapping("/auta")
    public String allCars(Model model)
    {
        model.addAttribute("samochody",samochodRepository.findAll());
        return "/admin/allFactory/AllCars";
    }
    @GetMapping("/auta/{id}")
    public String detailedInformation(Model model, @PathVariable Long id)
    {
        model.addAttribute("car",samochodRepository.findById(id).get());
        return "/admin/singleFactory/carInfo";
    }
    @GetMapping("/factory/{id}")
    public String detailedFactoryInformation(Model model,@PathVariable Long id)
    {
        model.addAttribute("oddzial", oddzialRepo.findById(id).get());
        return "/admin/singleFactory/factoryInfo";
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
        return "factoryInfo";
    }


    @GetMapping("/factory/{id}/auta")
    public String carsInFactory(@PathVariable Long id,Model model) {
        model.addAttribute("samochody", samochodRepository.findAll());
        model.addAttribute("oddzial", oddzialRepo.findById(id).get());
        return "/admin/singleFactory/carInFactory";
    }

    @GetMapping("/auta/zleceniaAuta/{id}")
    public String orderCars(@PathVariable Long id, Model model) {
        model.addAttribute("car", samochodRepository.findById(id).get());


        return "/admin/singleFactory/orderCar";
    }

    @GetMapping("/auta/{id}/edit/")
    public String editCarView(@PathVariable Long id, Model model) {
           model.addAttribute("car", samochodRepository.findById(id).get());
           model.addAttribute("oddzialy",oddzialRepo.findAll());

           return "/admin/singleFactory/editCar";
    }
    @PostMapping("/auta/{id}/edit/")
    public String updateCar(@PathVariable("id") Long id, @ModelAttribute("oddzialy") Oddzial oddzial, @ModelAttribute("test") Samochod samochod) {
    Samochod samochodToUpdate = samochodRepository.getOne(id);
    samochodToUpdate.setCena24(samochod.getCena24());
        Oddzial oddzialToUpdate = oddzialRepo.getOne(oddzial.getId());
        samochodToUpdate.setSamochod_oddzialu(oddzialToUpdate);
        samochodRepository.save(samochodToUpdate);
        return "redirect:/adminPanel";
    }




}
