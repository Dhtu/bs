package com.bs.springboot.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/autoSchedule")
    public void autoSchedule() throws Exception {
        System.out.println("start auto schedule");
//        return new PageInfo<>(hs, 20);
    }
}
