package com.bs.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CookieController {

    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpSession session) {
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        Object uid = session.getAttribute("id");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }

        return "index";
    }
}