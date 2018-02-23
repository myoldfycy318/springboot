package com.learn.demo.controller;


import com.learn.demo.entity.TestConfig;
import com.learn.demo.propreties.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class HiController {

    @Value("${paramsA}")
    private String paramx;

    @Value("${param_age}")
    private String param_age;

    @Autowired
    private Girl girl;

    @RequestMapping(value = "/Hi/{id}")
    public String say(){
        return paramx + param_age;
    }

    /**
     * 请求参数
     * @param id
     * @param reqParam
     * @return
     */
    @PostMapping(value = "/test/{id}")
    public String say(@PathVariable Integer id,@RequestParam String reqParam){
        return id + " " +reqParam;
    }

    @GetMapping("girl")
    public Girl testGirl(){
        return girl;
    }


    @Autowired
    private TestConfig testConfig;


    @GetMapping("/testConfig")
    public TestConfig testConfig(){
        return testConfig;
    }
}
