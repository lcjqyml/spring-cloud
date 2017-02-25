package com.milin.springcloud.simpileservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
public class LoggersController {

    @RequestMapping("/loggers.htm")
    public String loggersPage() {
        return "loggers";
    }

}
