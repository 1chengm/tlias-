package com.mcc.mapper;


import com.mcc.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Select("select * from operate_log")
    List<OperateLog> list();
}
