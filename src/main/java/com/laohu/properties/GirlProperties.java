package com.laohu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * Created by asus30 on 2017/8/12.
 */
//注入bean
@Component
//把 yml的前缀girl的文件注入
@ConfigurationProperties(prefix="girl")
public class GirlProperties {
    private String cupsize;
    @Min(value=18,message = "未成年少女禁止入内")
    private Integer age;

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
