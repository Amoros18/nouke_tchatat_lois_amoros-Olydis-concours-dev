package com.example.gestion.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	@GetMapping("hello")
    public String hello2() {
        return "Hello Word 3";
    }

	@GetMapping("helloo")
    public String hellop() {
        return "Hello, 3 Word";
    }

}
