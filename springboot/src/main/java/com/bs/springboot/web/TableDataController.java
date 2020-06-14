package com.bs.springboot.web;

import com.bs.springboot.pojo.TableData;
import com.bs.springboot.service.TableDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class TableDataController {
    @Autowired
    TableDataService tableDataService;

    /*restful 部分*/
    @GetMapping("/TableDatas")
    public PageInfo<TableData> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {
        PageHelper.startPage(start, size);
        List<TableData> hs = tableDataService.list();
        System.out.println(hs.size());

        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/TableDatas/{did}")
    public TableData get(@PathVariable("did") int did) throws Exception {
        System.out.println(did);
        TableData h = tableDataService.get(did);
        System.out.println(h);
        return h;
    }

    @PostMapping("/TableDatas")
    public String add(@RequestBody TableData h) throws Exception {
        tableDataService.add(h);
        return "success";
    }

    @DeleteMapping("/TableDatas/{did}")
    public String delete(TableData h) throws Exception {
        tableDataService.delete(h.getDid());
        return "success";
    }

    @PutMapping("/TableDatas/{did}")
    public String update(@RequestBody TableData h) throws Exception {
        tableDataService.update(h);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value = "/listTableData", method = RequestMethod.GET)
    public ModelAndView listTableData() {
        return new ModelAndView("listTableData");
    }

    @RequestMapping(value = "/editTableData", method = RequestMethod.GET)
    public ModelAndView editTableData() {
        return new ModelAndView("editTableData");
    }
}
