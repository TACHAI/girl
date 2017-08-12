package com.laohu.controller;

import com.laohu.domain.Girl;
import com.laohu.responsitory.GirlResponsitory;
import com.laohu.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by asus30 on 2017/8/12.
 */
@RestController
public class GirlController {
    private final static Logger logger=LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlResponsitory girlResponsitory;
    @Autowired
    private GirlService girlService;
    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlResponsitory.findAll();
    }

    /**
     * 添加女生
     * @return
     */
    @PostMapping(value = "/girls")
    public  Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           System.out.println(bindingResult.getFieldError().getDefaultMessage());
           return  null;
       }

        girl.setCupSize(girl.getCupSize());
       girl.setAge(girl.getAge());
       return girlResponsitory.save(girl);
    }
    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlfindById(@PathVariable("id") Integer id){
        return  girlResponsitory.findOne(id);
    }
    //更新
    @PutMapping(value = "girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlResponsitory.save(girl);
    }

    //删除
    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlResponsitory.delete(id);
    }

    @RequestMapping(value ="girlss/two" )
    public void girlTwo(){
        girlService.insertTwo();
    }
}
