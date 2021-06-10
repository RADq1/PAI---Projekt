package wyp.aut.wypa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.SamochodRepository;

@Controller
public class AdminController {

    @Autowired
    SamochodRepository samochodRepository;
    @Autowired
    OddzialRepo oddzialRepo;


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
    public String carsInFactory(@PathVariable Long id,Model model)
    {
       model.addAttribute("samochody",samochodRepository.findAll());
       model.addAttribute("oddzial",oddzialRepo.findById(id).get());
        return "/admin/singleFactory/carInFactory";
    }



}
