package com.laohu.service;

import com.laohu.domain.Girl;
import com.laohu.responsitory.GirlResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by asus30 on 2017/8/12.
 */
@Service
public class GirlService {
    @Autowired
    private GirlResponsitory girlResponsitory;
    //事务注解
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlResponsitory.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("F");
        girlB.setAge(19);
        girlResponsitory.save(girlB);
    }
}
