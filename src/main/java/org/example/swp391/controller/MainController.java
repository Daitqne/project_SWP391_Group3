package org.example.swp391.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping()
    public String test(){
        return "ex";
    }

    @GetMapping("/main")
    public String abcd(){
        return "ex";
    }

    private void hihi(){
        System.out.println("hihi");
    }
}
