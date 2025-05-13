package com.mcc.service;


import com.mcc.pojo.PageResult;
import com.mcc.pojo.StuQueryParam;
import com.mcc.pojo.Student;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StuQueryParam stuQueryParam);

    void delete(List<Integer> ids);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void violation(Integer id, Integer score);
}
