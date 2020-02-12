package com.arnold.febs.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }

    @RequestMapping("/test/testShiroSession")
    @ResponseBody
    public String test(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("test", "testtest1123");
        Subject subject = SecurityUtils.getSubject();
        Session session1 = subject.getSession();
        String test = (String) session1.getAttribute("test");
        return test;

    }
}
