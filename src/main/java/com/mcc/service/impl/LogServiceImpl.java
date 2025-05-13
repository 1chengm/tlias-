package com.mcc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcc.mapper.LogMapper;
import com.mcc.pojo.OperateLog;
import com.mcc.pojo.PageResult;
import com.mcc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer PageSize) {
     PageHelper.startPage(page, PageSize);

     List<OperateLog> loglist = logMapper.list();

     Page<OperateLog> p = (Page<OperateLog>) loglist;

     return new PageResult<>(p.getTotal(), p.getResult());
    }
}
