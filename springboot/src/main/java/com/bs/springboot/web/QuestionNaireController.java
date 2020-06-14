package com.bs.springboot.web;

import com.bs.springboot.pojo.QuestionNaire;
import com.bs.springboot.service.QuestionNaireService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class QuestionNaireController {
    @Autowired
    QuestionNaireService questionNaireService;

    /*restful 部分*/
    @GetMapping("/QuestionNaires")
    public PageInfo<QuestionNaire> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {
        PageHelper.startPage(start, size);
        List<QuestionNaire> hs = questionNaireService.list();
        System.out.println(hs.size());

        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/QuestionNaires/{qid}")
    public QuestionNaire get(@PathVariable("qid") int qid) throws Exception {
        System.out.println(qid);
        QuestionNaire h = questionNaireService.get(qid);
        System.out.println(h);
        return h;
    }

    @PostMapping("/QuestionNaires")
    public String add(@RequestBody QuestionNaire h) throws Exception {
        questionNaireService.add(h);
        return "success";
    }

    @DeleteMapping("/QuestionNaires/{qid}")
    public String delete(QuestionNaire h) throws Exception {
        questionNaireService.delete(h.getQid());
        return "success";
    }

    @PutMapping("/QuestionNaires/{qid}")
    public String update(@RequestBody QuestionNaire h) throws Exception {
        questionNaireService.update(h);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value = "/listQuestionNaire", method = RequestMethod.GET)
    public ModelAndView listQuestionNaire() {
        System.out.println("hey");
        return new ModelAndView("listQuestionNaire");
    }

    @RequestMapping(value = "/editQuestionNaire", method = RequestMethod.GET)
    public ModelAndView editQuestionNaire() {
        return new ModelAndView("editQuestionNaire");
    }
}
