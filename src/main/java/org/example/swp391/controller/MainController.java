package org.example.swp391.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping()
    public String test(){
        return "login";
    }

    @GetMapping("/ok")
    public String ok(){
        return "ok";
    }
    @GetMapping("/not")
    public String not(){
        return "not";
    }
}
