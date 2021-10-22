package com.feskova.hw.controllers;

import com.feskova.hw.models.Username;
import com.feskova.hw.services.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsernameController {
    private UsernameService usernameService;

    @Autowired
    public void setUsernameService(UsernameService usernameService) {
        this.usernameService = usernameService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Username> usernameList = usernameService.getAll();
        model.addAttribute("usernames", usernameList);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
