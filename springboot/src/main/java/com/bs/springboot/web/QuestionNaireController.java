package com.bs.springboot.web;

import com.bs.springboot.pojo.QuestionNaire;
import com.bs.springboot.service.QuestionNaireService;
import com.bs.springboot.service.serviceHelper.SessionHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class QuestionNaireController {
    final
    QuestionNaireService questionNaireService;

    public QuestionNaireController(QuestionNaireService questionNaireService) {
        this.questionNaireService = questionNaireService;
    }

    /*restful 部分*/
    @GetMapping("/QuestionNaires")
    public PageInfo<QuestionNaire> list(@RequestParam(value = "start", defaultValue = "1") int start,
                                        @RequestParam(value = "size", defaultValue = "20") int size,
                                        HttpSession session) {
        int uid = SessionHelper.GetUid(session);
        List<QuestionNaire> hs = null;
        if (uid >= 0) {
            PageHelper.startPage(start, size);
            hs = questionNaireService.SelectedList(uid);
            System.out.println(hs.size());
        }


        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/QuestionNaires/{qid}")
    public QuestionNaire get(@PathVariable("qid") int qid) {
        System.out.println(qid);
        QuestionNaire h = questionNaireService.get(qid);
        System.out.println(h);
        return h;
    }

    @PostMapping("/QuestionNaires")
    public String add(@RequestBody QuestionNaire h, HttpSession session) {
        int uid = SessionHelper.GetUid(session);
        h.setUid(uid);
        questionNaireService.add(h);
        return "success";
    }

    @DeleteMapping("/QuestionNaires/{qid}")
    public String delete(QuestionNaire h) {
        questionNaireService.delete(h.getQid());
        return "success";
    }

    @PutMapping("/QuestionNaires/{qid}")
    public String update(@RequestBody QuestionNaire h) {
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
