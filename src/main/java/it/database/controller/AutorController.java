package it.database.controller;

import it.database.entity.Autor;
import it.database.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService service;
    @RequestMapping("/{id}")
    public String showAutor(@PathVariable int id, Model model){
        model.addAttribute("autor", service.getById(id));
        return "autor";
    }
    @RequestMapping("/edit/{id}")
    public String editAutor(@PathVariable int id, Model model){
        model.addAttribute("autor", service.getById(id));
        return "editAutor";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/editAutor")
    public String editAutor(@ModelAttribute Autor autor){
        service.update(autor);
        return "redirect:/autor/"+autor.getId();
    }
}
