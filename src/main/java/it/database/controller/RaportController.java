package it.database.controller;

import it.database.entity.Article;
import it.database.entity.Grade;
import it.database.entity.Raport;
import it.database.entity.Reviewer;
import it.database.service.ArticleService;
import it.database.service.RaportService;
import it.database.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Controller
@RequestMapping("/raport")
public class RaportController {
    @Autowired
    RaportService service;
    @Autowired
    ReviewerService reviewerService;
    @Autowired
    ArticleService articleService;
    @RequestMapping("/{id}")
    public String showRaport(@PathVariable int id, Model model){
        model.addAttribute("raport", service.getById(id));
        return "raport";
    }
    @RequestMapping("/new")
    public String newGrade(Model model){
        model.addAttribute("raport", new Raport());
        model.addAttribute("articles", articleService.getAll());
        model.addAttribute("reviewers", reviewerService.getAll());
        return "newRaport";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newRaport(@ModelAttribute Raport raport){
        int articleId = raport.getArticleId();
        int reviewerId = raport.getReviewerId();
        raport.setArticle(articleService.getById(articleId));
        raport.setReviewer(reviewerService.getById(reviewerId));
        int id = service.save(raport);
        return "redirect:/raport/"+id;
    }
    @RequestMapping("/edit/{id}")
    public  String editRaport(@PathVariable int id, Model model){
        model.addAttribute("raport", service.getById(id));
        model.addAttribute("articles", articleService.getAll());
        model.addAttribute("reviewers", reviewerService.getAll());
        return "editRaport";
    }
    @RequestMapping(value = "editRaport", method = RequestMethod.POST)
    public String editRaport(@ModelAttribute Raport raport){
        Raport raport1 = service.getById(raport.getId());
        raport.setArticle(raport1.getArticle());
        raport.setReviewer(raport1.getReviewer());
        service.update(raport);
        return "redirect:/raport/"+raport.getId();
    }

    @RequestMapping("/addArticle")
    public void addArticle(@RequestParam int raportId, @RequestParam int articleId){
        Raport grade = service.getById(raportId);
        Article article = articleService.getById(articleId);
        grade.setArticle(article);
        service.update(grade);
    }

    @RequestMapping("/addReviewer")
    public void addReviewer(@RequestParam int raportId, @RequestParam int reviewerId){
        Raport grade = service.getById(raportId);
        Reviewer reviewer = reviewerService.getById(reviewerId);
        grade.setReviewer(reviewer);
        service.update(grade);
    }
}
