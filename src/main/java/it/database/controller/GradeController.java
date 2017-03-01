package it.database.controller;

import it.database.entity.Article;
import it.database.entity.Grade;
import it.database.entity.Reviewer;
import it.database.service.ArticleService;
import it.database.service.GradeService;
import it.database.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    GradeService service;
    @Autowired
    ReviewerService reviewerService;
    @Autowired
    ArticleService articleService;
    @RequestMapping("/{id}")
    public String showGrade(@PathVariable int id, Model model){
        model.addAttribute("grade", service.getById(id));
        return "grade";
    }
    @RequestMapping("/new")
    public String newGrade(Model model){
        model.addAttribute("grade", new Grade());
        model.addAttribute("articles", articleService.getAll());
        model.addAttribute("reviewers", reviewerService.getAll());
        return "newGrade";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newGrade(@ModelAttribute Grade grade){
        int articleId = grade.getArticleId();
        int reviewerId = grade.getReviewerId();
        grade.setArticle(articleService.getById(articleId));
        grade.setReviewer(reviewerService.getById(reviewerId));
        int id = service.save(grade);
        return "redirect:/grade/"+id;
    }

    @RequestMapping("/edit/{id}")
    public  String editGrade(@PathVariable int id, Model model){
        model.addAttribute("grade", service.getById(id));
        model.addAttribute("articles", articleService.getAll());
        model.addAttribute("reviewers", reviewerService.getAll());
        return "editGrade";
    }
    @RequestMapping(value = "editGrade", method = RequestMethod.POST)
    public  String editGrade(@ModelAttribute Grade grade){
        Article article = service.getById(grade.getId()).getArticle();
        Reviewer reviewer = service.getById(grade.getId()).getReviewer();
        grade.setArticle(article);
        grade.setReviewer(reviewer);
        service.update(grade);
        return "redirect:/grade/"+grade.getId();
    }
    @RequestMapping("/addArticle")
    public void addArticle(@RequestParam int gradeId, @RequestParam int articleId){
        Grade grade = service.getById(gradeId);
        Article article = articleService.getById(articleId);
        grade.setArticle(article);
        service.update(grade);
    }
    @RequestMapping("/addReviewer")
    public void addReviewer(@RequestParam int gradeId, @RequestParam int reviewerId){
        Grade grade = service.getById(gradeId);
        Reviewer reviewer = reviewerService.getById(reviewerId);
        grade.setReviewer(reviewer);
        service.update(grade);
    }
}
