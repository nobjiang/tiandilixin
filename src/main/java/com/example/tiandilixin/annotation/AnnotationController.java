package com.example.tiandilixin.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiandilixin
 * @description: annonation
 * @author: zhaoliang
 * @create: 2021-07-23 15:46
 **/
@RestController

public class AnnotationController {



    @GetMapping("annotest")
    @Log(1)
    public String test(String test,String hi){
        int a=1/0;
        return test+hi;
    }

}
