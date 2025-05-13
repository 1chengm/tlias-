package com.mcc.mapper;

import com.mcc.pojo.StuQueryParam;
import com.mcc.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public List<Student> list(StuQueryParam stuQueryParam);

    void deleteByIds(List<Integer> ids);

    @Insert("insert into student(name,no,gender,degree,phone,id_card,is_college,address,graduation_date,clazz_id,create_time,update_time) "+
            "VALUES(#{name},#{no},#{gender},#{degree},#{phone},#{idCard},#{isCollege},#{address},#{graduationDate},#{clazzId},#{createTime},#{updateTime})")
    void insert(Student student);

    @Select("select * from student where id = #{id}")
    Student getById(Integer id);

    @Update("update student set name=#{name}, no=#{no}, gender=#{gender}, phone=#{phone},degree=#{degree}," +
            "id_card=#{idCard},is_college=#{isCollege},address=#{address},graduation_date=#{graduationDate},clazz_id=#{clazzId},update_time=#{updateTime} where id=#{id} ")
    void update(Student student);

    @Update("update student set violation_count = violation_count + 1, violation_score = violation_score + #{score} where id = #{id}")
    void violation(Integer id, Integer score);

    @MapKey("name")
    List<Map> countStudentDegreeData();

    @MapKey("clazz")
    List<Map<String, Object>> countStudentCountData();
}
