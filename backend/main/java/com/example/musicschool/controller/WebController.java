package com.example.musicschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping({ "/", "/todos", "/about" /* 他のVue Routerのルート */ })
    public String forwardToIndex() {
        return "forward:/index.html";
    }
}