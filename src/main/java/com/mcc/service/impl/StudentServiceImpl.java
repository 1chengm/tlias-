package com.mcc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcc.mapper.StudentMapper;
import com.mcc.pojo.PageResult;
import com.mcc.pojo.StuQueryParam;
import com.mcc.pojo.Student;
import com.mcc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StuQueryParam stuQueryParam) {
        //        1.设置分页参数
        PageHelper.startPage(stuQueryParam.getPage(),stuQueryParam.getPageSize());
        //        2.进行业务查询,格式转换
        List<Student> stulist = studentMapper.list(stuQueryParam);
        Page<Student> p = (Page<Student>) stulist;
        //        3.封装返回结果
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void save(Student student) {
        // 补全属性值
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.violation(id, score);
    }
}
