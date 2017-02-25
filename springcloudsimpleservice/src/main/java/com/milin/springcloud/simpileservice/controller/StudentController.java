package com.milin.springcloud.simpileservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/25.
 */
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping("/log")
    public String testLogger() {
        logger.debug("This is debug.");
        logger.info("This is info.");
        logger.warn("This is warn.");
        logger.error("This is error.");
        return "Hello World!!!";
    }

}
