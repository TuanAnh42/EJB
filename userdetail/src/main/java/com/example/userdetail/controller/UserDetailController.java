package com.example.userdetail.controller;

import com.example.userdetail.implement.UserDetailImpl;
import com.example.userdetail.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class UserDetailController {

    private UserDetailImpl userDetailImpl;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("list", userDetailImpl.getAllUser());
        return "HomePage";
    }

    @GetMapping("/addnew")
    public String addNewUser(Model model) {
        UserDetail userDetail = new UserDetail();
        model.addAttribute("userDetail", userDetail);
        return "addUser";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("userDetail") UserDetail userDetail) {
        userDetailImpl.save(userDetail);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        UserDetail userDetail = userDetailImpl.getById(id);
        model.addAttribute("userDetail", userDetail);
        return "updateUser";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        userDetailImpl.deleteWithId(id);
        return "redirect:/";

    }
}
