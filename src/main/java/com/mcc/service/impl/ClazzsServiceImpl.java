package com.mcc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcc.mapper.ClazzsMapper;
import com.mcc.pojo.Clazzs;
import com.mcc.pojo.ClazzsQueryParam;
import com.mcc.pojo.PageResult;
import com.mcc.service.ClazzsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ClazzsServiceImpl implements ClazzsService {


    @Autowired
    private ClazzsMapper clazzsMapper;
    @Override
    public PageResult<Clazzs> page(ClazzsQueryParam clazzsQueryParam) {
        //1设置分页数据
        PageHelper.startPage(clazzsQueryParam.getPage(),clazzsQueryParam.getPageSize());
        //2获取封装数据
        List<Clazzs> clazzsList = clazzsMapper.list(clazzsQueryParam);
        Page<Clazzs> p = (Page<Clazzs>) clazzsList;
        //3返回封装结果
        return new PageResult<Clazzs>(p.getTotal(),p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        clazzsMapper.deleteById(id);
    }

    @Override
    public void save(Clazzs clazzs) {
//        1.补全信息
        clazzs.setCreateTime(LocalDateTime.now());
        clazzs.setUpdateTime(LocalDateTime.now());
        clazzsMapper.insert(clazzs);
    }

    @Override
    public Clazzs getInfo(Integer id) {
        return clazzsMapper.getById(id);
    }

    @Override
    public void update(Clazzs clazzs) {
//1.基础信息补全
        clazzs.setUpdateTime(LocalDateTime.now());
        clazzsMapper.update(clazzs);
    }

    @Override
    public List<Clazzs> list() {
        return clazzsMapper.findAll();
    }
}
