package it.database.controller;

import it.database.entity.Annotation;
import it.database.entity.Article;
import it.database.entity.Autor;
import it.database.service.AnnotationService;
import it.database.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Controller
@RequestMapping("/annotation")
public class AnnotationController {
    @Autowired
    AnnotationService service;
    @Autowired
    ArticleService articleService;
    @RequestMapping(value = "/{id}")
    public String showAnnotation(@PathVariable int id, Model model){
        model.addAttribute("annotation", service.getById(id));
        return "annotation";
    }
    @RequestMapping("/new")
    public String newAnnotation(Model model){
        model.addAttribute("annotation", new Annotation());
        model.addAttribute("articles", articleService.getAll());
        return "newAnnotation";
    }
    @RequestMapping(value = "addAnnotation", method = RequestMethod.POST)
    public String newAnnotation(@ModelAttribute Annotation annotation){
        int articleId = annotation.getArticleId();
        annotation.setArticle(articleService.getById(articleId));
        int id = service.save(annotation);
        return "redirect:/annotation/"+id;
    }
    @RequestMapping("/edit/{id}")
    public  String editAnnotation(@PathVariable int id, Model model){
        model.addAttribute("annotation", service.getById(id));
        model.addAttribute("articles", articleService.getAll());
        return "editAnnotation";
    }
    @RequestMapping(value = "editAnnotation", method = RequestMethod.POST)
    public String editAnnotation(@ModelAttribute Annotation annotation){
        Article article = service.getById(annotation.getId()).getArticle();
        annotation.setArticle(article);
        service.update(annotation);
        return "redirect:/annotation/"+annotation.getId();
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public String addArticle(@RequestParam("articleId") int articleId, @RequestParam("gradeId") int annotationId){
        Annotation annotation = service.getById(annotationId);
        Article article = articleService.getById(articleId);
        annotation.setArticle(article);
        service.update(annotation);
        return "success";
    }
}
