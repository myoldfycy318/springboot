package com.learn.demo.controller;


import com.learn.demo.entity.TestConfig;
import com.learn.demo.propreties.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/demo")
public class HiController {

    private final Logger logger = LoggerFactory.getLogger(HiController.class);

    @Value("${paramsA}")
    private String paramx;

    @Value("${param_age}")
    private String param_age;

    @Autowired
    private Girl girl;

    @RequestMapping(value = "/Hi/{id}")
    public String say(HttpServletRequest request) {
        return paramx + param_age;
    }

    /**
     * 请求参数
     *
     * @param id
     * @param reqParam
     * @return
     */
    @PostMapping(value = "/test/{id}")
    public String say(@PathVariable Integer id, @RequestParam String reqParam) {
        return id + " " + reqParam;
    }

    @GetMapping("girl")
    public Girl testGirl() {
        return girl;
    }


    @Autowired
    private TestConfig testConfig;


    @GetMapping("/testConfig")
    public TestConfig testConfig() {
        return testConfig;
    }

    @GetMapping("log2es")
    public String log2es() {


        for (int i = 0; i < 100; i++) {
            logger.info("log2es...." + i);
        }
        return "ok";
    }
}
