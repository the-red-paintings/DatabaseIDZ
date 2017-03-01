package it.database.controller;

import it.database.entity.Article;
import it.database.entity.Keywords;
import it.database.service.ArticleService;
import it.database.service.KeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Controller
@RequestMapping("/keywords")
public class KeywordsController {
    @Autowired
    KeywordsService service;
    @Autowired
    ArticleService articleService;
    @RequestMapping("/{id}")
    public String showKeywords(@PathVariable int id, Model model){
        model.addAttribute("keyword", service.getById(id));
        return "keywords";
    }
    @RequestMapping("/new")
    public String newKeywords(Model model){
        model.addAttribute("keywords", new Keywords());
        model.addAttribute("articles", articleService.getAll());
        return "newKeywords";
    }
    @RequestMapping(value = "/addKeywords", method = RequestMethod.POST)
    public String newKeywords(@ModelAttribute Keywords keywords){
        Article article = service.getById(keywords.getId()).getArticle();
        keywords.setArticle(article);
        int id = service.save(keywords);
        return "redirect:/keywords/"+id;
    }
    @RequestMapping("/edit/{id}")
    public String editKeywords(@PathVariable int id, Model model){
        model.addAttribute("keywords", service.getById(id));
        model.addAttribute("articles", articleService.getAll());
        return "editKeywords";
    }
    @RequestMapping(value = "editKeyword", method = RequestMethod.POST)
    public String editKeywords(@ModelAttribute Keywords keywords){
        Article article = service.getById(keywords.getId()).getArticle();
        keywords.setArticle(article);
        service.update(keywords);
        return "redirect:/keywords/"+keywords.getId();
    }
    @RequestMapping("addArticle")
    public String addAutor(@RequestParam int articleId, @RequestParam int keywordId){
        Keywords keywords = service.getById(keywordId);
        Article article = articleService.getById(articleId);
        keywords.setArticle(article);
        service.update(keywords);
        return "success";
    }
}
