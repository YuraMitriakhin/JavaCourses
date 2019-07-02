package com.gmail.yuramitryahin.web;

import com.gmail.yuramitryahin.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import  java.util.logging.*;

@Slf4j
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @RequestMapping("/register")
    public String loginPage() {
        return "register";
    }

   // @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String getLogin(Model model,
                           @RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password) {

        log.info("Username:"+username+" Email:"+email+" Password:"+password);
        
        return "redirect:/";
    }


}