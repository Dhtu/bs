package com.bs.springboot.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView signUp() {
        return new ModelAndView("signUp");
    }

    @RequestMapping(value = "/testHTML", method = RequestMethod.GET)
    public ModelAndView testHTML() {
        return new ModelAndView("testHTML");
    }
}
