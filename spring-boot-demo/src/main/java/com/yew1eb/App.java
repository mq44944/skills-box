package com.yew1eb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhouhai
 * @createTime 16/4/17
 * @description
 */
@SpringBootApplication
@Controller
public class App {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
