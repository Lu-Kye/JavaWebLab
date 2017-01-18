package com.lukye.JavaWebLab.SpringExample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserLoginController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "Test";
    }
}