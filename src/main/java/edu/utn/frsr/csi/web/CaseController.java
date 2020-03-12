package edu.utn.frsr.csi.web;

import edu.utn.frsr.csi.model.Case;
import edu.utn.frsr.csi.services.ServiceCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Controller
public class CaseController {

    private ServiceCase serviceCase;

    public CaseController(ServiceCase serviceCase){
        this.serviceCase = serviceCase;
    }

    @RequestMapping("/casos")
    public ModelAndView showCases(){
        ModelAndView modelAndView = new ModelAndView("casos");

        List<Case> casos = serviceCase.getAllCases();
        modelAndView.addObject("casos", casos);
        return modelAndView;
    }

    @RequestMapping(value = "/add_caso", method = RequestMethod.GET)
    public ModelAndView newCase(){
        ModelAndView modelAndView = new ModelAndView("form_caso");

        Case caso = new Case();
        modelAndView.addObject("action", "/add_caso");
        modelAndView.addObject("buttonLabel", "Crear");
        modelAndView.addObject("method", "post");
        modelAndView.addObject("caso", caso);
        return modelAndView;
    }

    @RequestMapping(value = "/add_caso", method = RequestMethod.POST)
    public String createCase(@ModelAttribute("caso") Case caso){
        serviceCase.create(caso);
        return "redirect:/casos";
    }

    @RequestMapping(value = "/edit_caso/{id}", method = RequestMethod.GET)
    public String editCase(@PathVariable("id") Long id, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("form_caso");

        if(!modelMap.containsAttribute("caso")){
            Case caso = serviceCase.findById(id).get();
            modelMap.addAttribute("caso", caso);
        }
        modelMap.addAttribute("action", "/edit_caso");
        modelMap.addAttribute("buttonLabel", "Editar");
        modelMap.addAttribute("method", "PUT");
        return "form_caso";
    }

    @RequestMapping(value = "/edit_caso", method = RequestMethod.POST)
    public String saveCase(@ModelAttribute("caso") Case caso){
        serviceCase.update(caso);
        return "redirect:/casos";
    }

}
