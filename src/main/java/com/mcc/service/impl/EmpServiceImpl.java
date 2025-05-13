package com.mcc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcc.mapper.EmpExprMapper;
import com.mcc.mapper.EmpMapper;
import com.mcc.pojo.*;
import com.mcc.service.EmpLogService;
import com.mcc.service.EmpService;
import com.mcc.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getUsernameAndPassword(emp);
        if(empLogin != null){
            //1. 生成JWT令牌
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id", empLogin.getId());
            dataMap.put("username", empLogin.getUsername());

            String jwt = JwtUtils.generateJwt(dataMap);
            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), jwt);
            return loginInfo;
        }
        return null;
    }

//原始分页代码
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.list(start, pageSize);
//        Long total =  empMapper.count();
//        return new PageResult<Emp>(total, empList);
//
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
//      设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
//       获取分页数据
        List<Emp> empList = empMapper.list(empQueryParam);
//      解析封装结果
        Page<Emp> p = (Page<Emp>)empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Emp emp) {
       try {
           //1.基础信息补全.
           emp.setCreateTime(LocalDateTime.now());
           emp.setUpdateTime(LocalDateTime.now());
           //2.保存基础信息
           empMapper.insert(emp);
           //3.增加工作经历.
           Integer empId = emp.getId();
           List<EmpExpr> exprList = emp.getExprList();
           if ( !CollectionUtils.isEmpty(exprList) ) {
               exprList.forEach(empExpr -> {
                   empExpr.setEmpId(empId);
               });
               //设置工作经历所属员工.

               //将员工工作经历插入数据库.
               empExprMapper.insertBatch(exprList);
           }
       } finally {
           //4.记录日志.
           EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "添加员工信息:" + emp.toString());//id自增
           empLogService.insertLog(empLog);
       }
    }
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional
    @Override
    public void update(Emp emp) {
//        1.基础信息补全.
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);//更新信息。
        Integer empId = emp.getId();
//        2.删除原有工作经历.
        empExprMapper.deleteByEmpIds(Arrays.asList(empId));//转换为列表
//        3.插入新的工作经历.
        List<EmpExpr> exprList = emp.getExprList();
        if ( !CollectionUtils.isEmpty(exprList) ) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(empId);
                empExprMapper.insertBatch(exprList);
            });
        }

    }

    @Override
    public List<Emp> list() {
        return empMapper.findAll();
    }

    @Override
    public Emp getByDeptId(Integer id) {
        return empMapper.getByDeptId(id);
    }

}
