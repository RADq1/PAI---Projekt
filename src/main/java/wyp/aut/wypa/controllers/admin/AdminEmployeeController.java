package wyp.aut.wypa.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wyp.aut.wypa.Services.SamochodService;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.entities.Pracownik;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.PracownikRepo;
import wyp.aut.wypa.repository.SamochodRepository;

@Controller
public class AdminEmployeeController {

    @Autowired
    SamochodRepository samochodRepository;
    @Autowired
    OddzialRepo oddzialRepo;
    @Autowired
    SamochodService samochodService;
    @Autowired
    PracownikRepo pracownikRepo;






   @GetMapping("/allEmployee")
    public String allEmployee(Model model)
    {
        model.addAttribute("employees",pracownikRepo.findAll());
        return "/admin/allFactory/allEmployees";
    }
    @GetMapping("/allEmployee/{id}/edit/")
    public String editEmployeeView(@PathVariable Long id, Model model) {
        model.addAttribute("employee", pracownikRepo.findById(id).get());

        return "/admin/singleFactory/employee/editEmployee";
    }
    @PostMapping("/allEmployee/{id}/edit/")
    public String editEmployeeSet(@PathVariable("id") Long id, @ModelAttribute("employee") Pracownik pracownik) {
       Pracownik employeeToUpdate = pracownikRepo.getOne(id);
       employeeToUpdate.setPensja(pracownik.getPensja());
        pracownikRepo.save(employeeToUpdate);
        return "redirect:/adminPanel";
    }

    @GetMapping("/factory/{id}/employee")
    public String employeeInFactory(@PathVariable Long id,Model model) {
        model.addAttribute("employees", pracownikRepo.findAll());
        model.addAttribute("oddzial", oddzialRepo.findById(id).get());
        return "/admin/singleFactory/employee/employeeInFactory";
    }




}

