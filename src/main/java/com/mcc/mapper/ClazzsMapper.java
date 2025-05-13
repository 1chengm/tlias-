package com.mcc.mapper;

import com.mcc.pojo.Clazzs;
import com.mcc.pojo.ClazzsQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface ClazzsMapper {

    public List<Clazzs> list(ClazzsQueryParam clazzsQueryParam);


    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into clazz(name,room, master_id,begin_date,end_date, subject,create_time, update_time)" +
            " values(#{name},#{room},#{MasterId},#{beginDate},#{endDate},#{Subject},#{createTime},#{updateTime})")
    void insert(Clazzs clazzs);

    @Select("select * from clazz where id = #{id}")
    Clazzs getById(Integer id);

    @Update("update clazz set name = #{name},room = #{room}, master_id = #{MasterId},begin_date = #{beginDate},end_date = #{endDate}, subject = #{Subject},update_time = #{updateTime} where id = #{id}")
    void update(Clazzs clazzs);

    @Select("select * from clazz")
    List<Clazzs> findAll();
}
