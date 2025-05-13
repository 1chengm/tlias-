package com.mcc.service;


import com.mcc.pojo.Dept;
import com.mcc.pojo.Emp;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     */
    List<Dept> findAll();


    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);


}
