package com.laohu.controller;

import com.laohu.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus30 on 2017/8/8.
 */
@RestController
//在方法内所有的url前加say前缀
@RequestMapping("/say")
public class HelloConroller {
//    @Value("${cupSize}")  //传统的读 配置文件的方法
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
    private String content;
    @Autowired
    private GirlProperties girlProperties;
//可以从两个路径来访问hello和hi
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET )
    public String say(){
        return girlProperties.getCupsize();

    }
}
