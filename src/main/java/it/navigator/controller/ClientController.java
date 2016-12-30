package it.navigator.controller;

import it.navigator.dao.ClientDAO;
import it.navigator.entity.Client;
import it.navigator.entity.Container;
import it.navigator.service.ClientService;
import it.navigator.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
@Controller
public class ClientController {
    @Autowired
    private ClientService service;

        @RequestMapping("/")
        String test(Model model){

            List<Client> list = service.getAllClient();
            Container containerList = new Container();
            containerList.setList(list);
            model.addAttribute("container", containerList);
            return "index";
        }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(@ModelAttribute Container container){

        List<Client> list = container.getList();

        service.updateAll(list);
        return "redirect:/";
    }
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    Container updateAll(@RequestBody Container container){
        List<Client> list = container.getList();
        service.updateAll(list);

        Container container1 = new Container();
        container1.setList(service.getAllClient());

        return container1 ;
    }

}
