package com.bs.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bs.springboot.pojo.ClassRoom;
import com.bs.springboot.service.ClassRoomService;

@RestController
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;

    /*restful 部分*/
    @GetMapping("/classrooms")
    public PageInfo<ClassRoom> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {
        PageHelper.startPage(start, size);
        List<ClassRoom> hs = classRoomService.list();
        System.out.println(hs.size());

        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/classrooms/{id}")
    public ClassRoom get(@PathVariable("id") String id) throws Exception {
        System.out.println(id);
        ClassRoom h = classRoomService.get(id);
        System.out.println(h);
        return h;
    }

    @PostMapping("/classrooms")
    public String add(@RequestBody ClassRoom h) throws Exception {
        classRoomService.add(h);
        return "success";
    }

    @DeleteMapping("/classrooms/{id}")
    public String delete(ClassRoom h) throws Exception {
        classRoomService.delete(h.getId());
        return "success";
    }

    @PutMapping("/classrooms/{id}")
    public String update(@RequestBody ClassRoom h) throws Exception {
        classRoomService.update(h);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value = "/listClassroom", method = RequestMethod.GET)
    public ModelAndView listClassroom() {
        return new ModelAndView("listClassroom");
    }

    @RequestMapping(value = "/editClassroom", method = RequestMethod.GET)
    public ModelAndView editClassroom() {
        return new ModelAndView("editClassroom");
    }
}

