package com.bs.springboot.web;

import com.bs.springboot.pojo.QuestionNaire;
import com.bs.springboot.pojo.TableData;
import com.bs.springboot.service.QuestionNaireService;
import com.bs.springboot.service.TableDataService;
import com.bs.springboot.service.serviceHelper.SessionHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TableDataController {
    final
    TableDataService tableDataService;

    QuestionNaireService questionNaireService;

    public TableDataController(TableDataService tableDataService,QuestionNaireService questionNaireService) {
        this.tableDataService = tableDataService;
        this.questionNaireService = questionNaireService;
    }

    /*restful 部分*/
    @GetMapping("/TableDatas")
    public PageInfo<TableData> list(@RequestParam(value = "start", defaultValue = "1") int start,
                                    @RequestParam(value = "size", defaultValue = "20") int size,
                                    HttpSession session) {

        int uid = SessionHelper.GetUid(session);
        List<TableData> hs = null;
        if (uid >= 0) {
            PageHelper.startPage(start, size);
            hs = tableDataService.listSelected(uid);
            System.out.println(hs.size());
        }
        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/TableDatasQid/{qid}")
    public PageInfo<TableData> listQid(@RequestParam(value = "start", defaultValue = "1") int start,
                                       @RequestParam(value = "size", defaultValue = "20") int size,
                                       HttpSession session, @PathVariable int qid) {

        int uid = SessionHelper.GetUid(session);
        List<TableData> hs = null;
        if (uid >= 0) {
            PageHelper.startPage(start, size);
            hs = tableDataService.listSelectedQid(uid, qid);
            System.out.println(hs.size());
        }
        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/TableDatas/{did}")
    public TableData get(@PathVariable("did") int did) {
        System.out.println(did);
        TableData h = tableDataService.get(did);
        System.out.println(h);
        return h;
    }

    @PostMapping("/TableDatas")
    public String add(@RequestBody TableData h,
                      HttpSession session) {
        int uid = SessionHelper.GetUid(session);
        QuestionNaire questionNaire = questionNaireService.get(h.getQid());
        System.out.println(questionNaire);
        if (uid < 0 && questionNaire.getAuthority() == 1) {
            return "false1";
        }
//        h.setUid(uid);
        System.out.println(h);
        tableDataService.add(h);
        return "success";
    }

    @DeleteMapping("/TableDatas/{did}")
    public String delete(TableData h) {
        tableDataService.delete(h.getDid());
        return "success";
    }

    @PutMapping("/TableDatas/{did}")
    public String update(@RequestBody TableData h) {
        tableDataService.update(h);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value = "/listTableData", method = RequestMethod.GET)
    public ModelAndView listTableData() {
        return new ModelAndView("listTableData");
    }

    @RequestMapping(value = "/showTableData", method = RequestMethod.GET)
    public ModelAndView showTableData() {
        return new ModelAndView("showTableData");
    }

    @RequestMapping(value = "/editTableData", method = RequestMethod.GET)
    public ModelAndView editTableData() {
        return new ModelAndView("editTableData");
    }
}
