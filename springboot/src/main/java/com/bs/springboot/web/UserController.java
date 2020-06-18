package com.bs.springboot.web;

import com.bs.springboot.pojo.User;
import com.bs.springboot.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*restful 部分*/
    @GetMapping("/Users")
    public PageInfo<User> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "20") int size) {
        PageHelper.startPage(start, size);
        List<User> hs = userService.list();
        System.out.println(hs.size());

        return new PageInfo<>(hs, 20);
    }

    @GetMapping("/Users/{uid}")
    public User get(@PathVariable("uid") int uid) {
        System.out.println(uid);
        User h = userService.get(uid);
        System.out.println(h);
        return h;
    }

    @PostMapping("/Users")
    public String add(@RequestBody User h) {
        userService.add(h);
        return "success";
    }

    @DeleteMapping("/Users/{uid}")
    public String delete(User h) {
        userService.delete(h.getUid());
        return "success";
    }

    @PutMapping("/Users/{uid}")
    public String update(@RequestBody User h) {
        userService.update(h);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/selectUserName", method = RequestMethod.POST)
    public int selectUserName(@RequestBody User user) {
        System.out.println(user);
        return userService.login(user);
    }

    /*页面跳转 部分*/
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView listUser() {
        return new ModelAndView("listUser");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser() {
        return new ModelAndView("editUser");
    }
}
