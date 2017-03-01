package it.database.controller;

import it.database.entity.*;
import it.database.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Controller
public class ArticleController {
    @Autowired
    @Qualifier("service")
    private ArticleService service;
    @Autowired
    private KeywordsService keywordsService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private AnnotationService annotationService;
    @Autowired
    private RaportService raportService;
    @Autowired
    private ReviewerService reviewerService;
    @RequestMapping(value = "/")
    public String showAll(Model model){
        model.addAttribute("list", service.getAll());
        return "articles";
    }
    @RequestMapping("/new")
    public String newArticle(Model model){
        model.addAttribute("article", new Article());
        return "newArticle";
    }
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String newArticle(@ModelAttribute Article article){
         int id = service.save(article);
        return "redirect:/article/"+id;
    }
    @RequestMapping(value = "/article/{id}")
    public String showArticle(@PathVariable int id, Model model){
        service.getById(id).getAutors();
        model.addAttribute("article", service.getById(id));
        return "article";
    }
    @RequestMapping(value = "/article/edit/{id}")
    public String editArticle(@PathVariable int id, Model model){
        model.addAttribute("article", service.getById(id));
        model.addAttribute("keywords", keywordsService.getAll());
        model.addAttribute("autors", autorService.getAll());
        model.addAttribute("grades", gradeService.getAll());
        model.addAttribute("annotations", annotationService.getAll());
        model.addAttribute("raports", raportService.getAll());
        model.addAttribute("reviewers", reviewerService.getAll());
        return "editArticle";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/editarticle")
    public String editArticle(@ModelAttribute Article article){
        article.setAnnotations(service.getById(article.getId()).getAnnotations());
        article.setAutors(service.getById(article.getId()).getAutors());
        article.setGrades(service.getById(article.getId()).getGrades());
        article.setRaports(service.getById(article.getId()).getRaports());
        article.setKeywords(service.getById(article.getId()).getKeywords());
        article.setReviewers(service.getById(article.getId()).getReviewers());
        service.update(article);
        int id= article.getId();
        return "redirect:/article/"+id;
    }
    @RequestMapping("/addKeywords")
    public String addKeywords(@RequestParam int keywordId,@RequestParam int articleId){
        Article article = service.getById(articleId);
        List<Keywords> keywordses = article.getKeywords();
        Keywords keywords = keywordsService.getById(keywordId);
        keywordses.add(keywords);
        article.setKeywords(keywordses);
        service.update(article);
        return "";
    }

    @RequestMapping(value = "/addAnnotation", method = RequestMethod.POST)
    public String addAnnotation(@RequestParam int annotationId,@RequestParam int articleId){
        Article article = service.getById(articleId);
        List<Annotation> annotations = article.getAnnotations();
        Annotation annotation = annotationService.getById(annotationId);
        annotations.add(annotation);
        article.setAnnotations(annotations);
        service.update(article);
        return "";
    }

    @RequestMapping("/addAutor")
    public String addAutor(@RequestParam int autorId,@RequestParam int articleId){
        Article article = service.getById(articleId);
        List<Autor> autors = article.getAutors();
        Autor autor = autorService.getById(autorId);
        autors.add(autor);
        article.setAutors(autors);
        service.update(article);
        return "";
    }

    @RequestMapping("/addGrade")
    public String addGrade(@RequestParam int gradeId,@RequestParam int articleId){
        Article article = service.getById(articleId);
        List<Grade> keywordses = article.getGrades();
        Grade keywords = gradeService.getById(gradeId);
        keywordses.add(keywords);
        article.setGrades(keywordses);
        service.update(article);
        return "";
    }

    @RequestMapping("/addRaport")
    public String addRaport(@RequestParam int raportId,@RequestParam int articleId){
        Article article = service.getById(articleId);
        List<Raport> keywordses = article.getRaports();
        Raport keywords = raportService.getById(raportId);
        keywordses.add(keywords);
        article.setRaports(keywordses);
        service.update(article);
        return "";
    }

    @RequestMapping("/addReviewer")
    public String addReviewer(@RequestParam int reviewerId,@RequestParam int articleId){
        Article article = service.getById(articleId);
        List<Reviewer> keywordses = article.getReviewers();
        Reviewer keywords = reviewerService.getById(reviewerId);
        keywordses.add(keywords);
        article.setReviewers(keywordses);
        service.update(article);
        return "";
    }
}
