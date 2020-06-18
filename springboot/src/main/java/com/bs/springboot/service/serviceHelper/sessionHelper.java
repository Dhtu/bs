package com.bs.springboot.service.serviceHelper;

import javax.servlet.http.HttpSession;

public class sessionHelper {
    public static int GetUid(HttpSession session){
        Object uid = session.getAttribute("uid");
        if (uid == null) {
            System.out.println("不存在session");
            return -1;
        } else {
            System.out.println("存在session，uid=" + uid.toString());
            return (int)uid;
        }
    }
}
