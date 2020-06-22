package com.bs.springboot.web;

import com.bs.springboot.pojo.User;
import com.bs.springboot.service.UserService;
import com.bs.springboot.service.serviceHelper.SessionHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
        List<User> hs = userService.list();
        for (User user :
                hs) {
            if (user.getUname().equals(h.getUname())) {
                return "unameFalse";
            }
            if (user.getEmail().equals(h.getEmail())){
                return "emailFalse";
            }
        }
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
    public int selectUserName(@RequestBody User user, HttpSession session) {
        System.out.println(user);
        int state = userService.login(user);
        if (state == 2) {
            int uid = SessionHelper.GetUid(session);
            if (uid == -1 || uid != user.getUid()) {
                System.out.println("不存在session，设置uid=" + user.getUid());
                session.setAttribute("uid", user.getUid());
            } else {
                System.out.println("存在session，uid=" + uid);
            }
        }

        return state;
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
