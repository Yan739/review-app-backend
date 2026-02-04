package com.yann.review_app_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping(path = "String")
    public String getString(){
        return "Chaine de caractère transmise par Review App";
    }

    @GetMapping
    public List<String> getList(){
        return List.of("Hello", "World", "from", "Spring", "Boot");
    }
}

