package com.koreait.cgvproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("user-main")
    public ModelAndView main(){
        return new ModelAndView("/user/main");
    }

    @GetMapping("movies")
    public ModelAndView movies(){
        return new ModelAndView("/user/movies/movies");
    }
    @GetMapping("movies/detail-view")
    public ModelAndView detailview(){
        return new ModelAndView("/user/movies/detail-view");
    }
}