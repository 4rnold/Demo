package com.arnold.febs.system.controller;


import com.arnold.febs.common.consts.FebsConstant;
import com.arnold.febs.common.entity.FebsResponse;
import com.arnold.febs.common.properties.FebsProperties;
import com.arnold.febs.common.properties.ValidateCodeProperties;
import com.arnold.febs.common.service.ValidateCodeService;
import com.arnold.febs.system.entity.User;
import com.arnold.febs.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/cas")
public class CASLoginController {

    @Autowired
    ValidateCodeService validateCodeService;

    @Autowired
    private FebsProperties properties;


    @Autowired
    IUserService userService;


    @GetMapping("/login")
    public ModelAndView login() {

        //如果已经登录就跳转


        ModelAndView mav = new ModelAndView();
        System.out.println(111);
        System.out.println(222);
        log.debug("atestestsetsetsetst");
//        mav.setViewName(FebsUtil.view("login"));
        mav.addObject("name", "arnold");
        mav.setViewName("cas-login");
        return mav;
    }

    /**
     * http://server1:8081/xxl-sso-server/login?redirect_url=http://server3:8083/xxl-sso-web-sample-springboot/
     */
    @PostMapping("/login")
    @ResponseBody
    public FebsResponse postLogin(String username, String password, String verifyCode, boolean rememberMe, HttpServletRequest request) {
        //处理有redirectUrl情况
        String redirect_url = (String) request.getAttribute("redirect_url");

        HttpSession session = request.getSession();
//        validateCodeService.check(session.getId(),verifyCode);
        checkLoginCaptcha(request, verifyCode);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        subject.login(token);
        //更新最后登录时间..

        if (StringUtils.isNotBlank(redirect_url)) {
            return new FebsResponse().code(HttpStatus.FOUND).data(redirect_url);
        }

        return new FebsResponse().success();
    }

    @GetMapping("images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        createLoginCaptcha(request, response);
    }


    void createLoginCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        ValidateCodeProperties codeProperties = properties.getCode();
        String key = FebsConstant.REDIS_LOGIN_CODE_PREFIX + sessionId;
        validateCodeService.createByKey(response, key, codeProperties);
    }

    void checkLoginCaptcha(HttpServletRequest request, String verifyCode) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String key = FebsConstant.REDIS_LOGIN_CODE_PREFIX + sessionId;
        validateCodeService.check(key, verifyCode);
    }

    @GetMapping("image/regist-captcha")
    public void registCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        createRegistCaptcha(request, response);
    }

/*    @PostMapping("/regist")
    public FebsResponse regist(String username, String password, String verifyCode, HttpServletRequest request) {
        checkRegistCaptcha(request, verifyCode);
    }*/

    @RequestMapping("/regist")
    @ResponseBody
    public FebsResponse regist(String username, String password, String verifyCode, HttpServletRequest request) {
        checkRegistCaptcha(request, verifyCode);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.createUser(user);
        return new FebsResponse().success();
    }

    void createRegistCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        ValidateCodeProperties codeProperties = properties.getCode();
        String key = FebsConstant.REDIS_REGIST_CODE_PREFIX + sessionId;
        validateCodeService.createByKey(response, key, codeProperties);
    }

    void checkRegistCaptcha(HttpServletRequest request, String verifyCode) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String key = FebsConstant.REDIS_LOGIN_CODE_PREFIX + sessionId;
        validateCodeService.check(key, verifyCode);
    }
}
