package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User()); //binds the user object to the model/form; you have to tell Thymeleaf what object to use when it renders the page
        return "user/add"; //this is pointing to the file you are rendering
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
        if(errors.hasErrors()) {
            return "user/add";
        }
        return "user/index";
//        if (user.getPassword().equals(verify)) {
//            return "user/index";
//        }
//        else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }

    }


}