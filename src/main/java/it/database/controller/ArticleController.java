package it.database.controller;

import it.database.entity.Article;
import it.database.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Controller
public class ArticleController {
    @Autowired
    @Qualifier("service")
    private ArticleService service;
    @RequestMapping(value = "/")
    public String showAll(Model model){
        model.addAttribute("list", service.getAll());
        return "articles";
    }
    @RequestMapping(value = "/article/{id}")
    public  String showArticle(@PathVariable int id, Model model){
        model.addAttribute("article", service.getById(id));
        return "article";
    }
    @RequestMapping(value = "/article/edit/{id}")
    public String editArticle(@PathVariable int id, Model model){
        model.addAttribute("article", service.getById(id));
        return "editArticle";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/editarticle")
    public String editArticle(@ModelAttribute Article article){
        service.update(article);
        return "redirect:/article/"+article.getId();
    }
}
