package com.example.springbootdemo.spring.Security.CSRF_XSS;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class TestControllor {

    @RequestMapping("/testCSRF")
    public Object test(String name, String pass, HttpServletRequest request) {
        CsrfToken csrfToke = (CsrfToken) request.getAttribute("_csrf");

        return name+pass+csrfToke.getToken();
    }


    /**
        自定义JsonSerializer

     POST /testXSSJson HTTP/1.1
     Host: localhost:8082
     Content-Type: application/json
     Cache-Control: no-cache
     Postman-Token: 181cb03e-9c33-99ad-16ad-8f17cd3e07db

     {
     "id":"111",
     "name":"<script>aaaaaa</script>"
     }

     返回：
     {
     "id": 111,
     "name": "&amp;lt;script&amp;gt;aaaaaa&amp;lt;/script&amp;gt;"
     }
     */
    @RequestMapping("/testXSSJson")
    public Object testXSSJson(@RequestBody User user) {
        return user;
    }
}
