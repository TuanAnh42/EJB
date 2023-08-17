package com.example.userdetail.controller;

import com.example.userdetail.implement.SkillImpl;
import com.example.userdetail.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class SkillController {

    private SkillImpl skillImpl;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("list", skillImpl.getAllSkill());
        return "HomePage";
    }

    @GetMapping("/addnew")
    public String addNewSkill(Model model) {
        Skills skills = new Skills();
        model.addAttribute("skills", skills);
        return "addSkill";
    }

    @PostMapping("/save")
    public String saveSkill(@ModelAttribute("skills") Skills skills) {
        skillImpl.save(skills);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Skills skills = skillImpl.getById(id);
        model.addAttribute("skills", skills);
        return "updateSkill";
    }

    @GetMapping("/deleteSkill/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        skillImpl.deleteWithId(id);
        return "redirect:/";

    }
}
