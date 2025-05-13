package com.mcc.service;

import com.mcc.pojo.Emp;
import com.mcc.pojo.EmpQueryParam;
import com.mcc.pojo.LoginInfo;
import com.mcc.pojo.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    LoginInfo login(Emp emp);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> list();

    Emp getByDeptId(Integer id);
}
