package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerController {
    @GetMapping()
    public String showTempPage(){
        return ("/temp");
    }
}
