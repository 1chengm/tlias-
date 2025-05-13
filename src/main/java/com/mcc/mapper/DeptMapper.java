package com.mcc.mapper;

import com.mcc.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//
public interface DeptMapper {
    //起别名手动映射;
//    @Select("SELECT id, name, create_time createTime, update_time updateTime from dept order by update_time DESC")
    @Select("SELECT id, name, create_time , update_time  from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("DELETE from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("INSERT into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name} , update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);//绑定对象属性
}
