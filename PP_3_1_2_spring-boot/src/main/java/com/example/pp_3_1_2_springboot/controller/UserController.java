package com.example.pp_3_1_2_springboot.controller;


import com.example.pp_3_1_2_springboot.model.User;
import com.example.pp_3_1_2_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/allUsers")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "add-user";
    }

    @RequestMapping ("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/allUsers";
    }
    @RequestMapping("edit/{id}")
    public String editUser (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserId(id));
        return "update-user";
    }

    @RequestMapping("/update")
    public String updateUserInfo(@ModelAttribute("user") User user) {
//        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/allUsers";
    }

    @RequestMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }

}
