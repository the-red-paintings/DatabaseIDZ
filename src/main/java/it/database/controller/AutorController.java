package it.database.controller;

import it.database.entity.Article;
import it.database.entity.Autor;
import it.database.service.ArticleService;
import it.database.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService service;
    @Autowired
    ArticleService articleService;
    @RequestMapping("/{id}")
    public String showAutor(@PathVariable int id, Model model){
        service.getById(id).getArticles();
        model.addAttribute("autor", service.getById(id));
        return "autor";
    }
    @RequestMapping("/new")
    public String newAutor(Model model){
        model.addAttribute("autor", new Autor());
        return "newAutor";
    }
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(@RequestParam int articleId, @RequestParam int autorId){
        Autor autor = service.getById(autorId);
        autor.getArticles();
        Article article = articleService.getById(articleId);
        List<Article> articles = autor.getArticles();
        articles.add(article);
        autor.setArticles(articles);
        service.update(autor);
        return "success";
    }
    @RequestMapping("/add")
    public  String newAutor(@ModelAttribute Autor autor){
        int id = service.save(autor);
        return "redirect:/autor/"+id;
    }
    @RequestMapping("/edit/{id}")
    public String editAutor(@PathVariable int id, Model model){
        model.addAttribute("autor", service.getById(id));
        model.addAttribute("articles", articleService.getAll());
        return "editAutor";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/editAutor")
    public String editAutor(@ModelAttribute Autor autor){
        List<Article> list = service.getById(autor.getId()).getArticles();
        autor.setArticles(list);
        service.update(autor);
        return "redirect:/autor/"+autor.getId();
    }
}
