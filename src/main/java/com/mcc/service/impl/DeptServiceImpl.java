package com.mcc.service.impl;

import com.mcc.anno.LogOperation;
import com.mcc.mapper.DeptMapper;
import com.mcc.pojo.Dept;
import com.mcc.service.DeptService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Integer;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //补全属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //保存部门;
        deptMapper.insert(dept);
    }

    @LogOperation
    @Override
    public Dept getById(Integer id) {
        //通过路径来查询信息;
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //补全属性
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
