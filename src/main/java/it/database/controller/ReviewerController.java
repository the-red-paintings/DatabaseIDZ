package it.database.controller;

import it.database.entity.Article;
import it.database.entity.Grade;
import it.database.entity.Raport;
import it.database.entity.Reviewer;
import it.database.service.GradeService;
import it.database.service.RaportService;
import it.database.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Controller
@RequestMapping("/reviewer")
public class ReviewerController {
    @Autowired
    ReviewerService service;
    @Autowired
    RaportService raportService;
    @Autowired
    GradeService gradeService;
    @RequestMapping("/{id}")
    public String showReviewer(@PathVariable int id, Model model){
        model.addAttribute("reviewer", service.getById(id));
        service.getById(id).getArticles();
        service.getById(id).getRaportList();
        service.getById(id).getGradeList();
        return "reviewer";
    }
    @RequestMapping("/new")
    public String newGrade(Model model){
        model.addAttribute("reviewer", new Reviewer());
        return "newReviewer";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newGrade(@ModelAttribute Reviewer reviewer){
        int id = service.save(reviewer);
        return "redirect:/reviewer/"+id;
    }
    @RequestMapping("/edit/{id}")
    public String editReviewer(@PathVariable int id, Model model){
        model.addAttribute("reviewer", service.getById(id));
        model.addAttribute("grades", gradeService.getAll());
        model.addAttribute("raports", raportService.getAll());
        return "editReviewer";
    }
    @RequestMapping(value = "/editReviewer", method = RequestMethod.POST)
    public String editReviewer(@ModelAttribute("reviewer") Reviewer reviewer1){
        Reviewer reviewer = service.getById(reviewer1.getId());
        List<Article> articles = reviewer.getArticles();
        List<Grade> grades = reviewer.getGradeList();
        List<Raport> raports = reviewer.getRaportList();
        reviewer.setArticles(articles);
        reviewer.setGradeList(grades);
        reviewer.setRaportList(raports);
        service.update(reviewer);
        return "redirect:/reviewer/"+reviewer.getId();
    }
    @RequestMapping("addGrade")
    public void addGrade(@RequestParam int reviewerId, @RequestParam int gradeId){
        Reviewer reviewer = service.getById(reviewerId);
        Grade grade = gradeService.getById(gradeId);
        List<Grade> grades = reviewer.getGradeList();
        grades.add(grade);
        reviewer.setGradeList(grades);
        service.update(reviewer);
    }
    @RequestMapping("addRaport")
    public void addRaport(@RequestParam int reviewerId, @RequestParam int raportId){
        Reviewer reviewer = service.getById(reviewerId);
        Raport raport = raportService.getById(raportId);
        List<Raport> raports = reviewer.getRaportList();
        raports.add(raport);
        reviewer.setRaportList(raports);
        service.update(reviewer);
    }
}
