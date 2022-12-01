package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex")
public class HomeController {
    @GetMapping()
    public String showIndexPage(){
        return ("ex/index");
    }
    @GetMapping("/tem")
    public String showTempPage(){
        return ("ex/tem");
    }
}
