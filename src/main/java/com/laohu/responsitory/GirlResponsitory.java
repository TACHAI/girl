package com.laohu.responsitory;

import com.laohu.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by asus30 on 2017/8/12.
 */
public interface GirlResponsitory extends JpaRepository<Girl,Integer> {
    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
