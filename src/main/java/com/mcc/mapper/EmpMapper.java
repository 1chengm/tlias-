package com.mcc.mapper;

import com.mcc.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import com.mcc.pojo.Emp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
//---------------------------------------原始的分页查询操作
//     @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id")
//    //进行外连接左关联。查出所有员工共信息/
//    public List<Emp> findAll();

//    //分页查询
//    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id " +
//            "order by update_time limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);
//
//    //查询员工总数
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    Long count();
//
//    ----------------------------------------------基于page-helper实现
//    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id order by update_time")//基于xml注解来实现映射
//    List<Emp> list( String name, Integer gender,
//                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end);

//    --------------------------------优化，基于传入对象的方式传参,前端请求参数与实体类属性名一致，且优化xml注解where与if
    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")//主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    /**
     * 统计员工工作信息
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);

    @Select("select * from emp")
    List<Emp> findAll();

    @Select("select * from emp where dept_id = #{id}")
    Emp getByDeptId(Integer id);
}
