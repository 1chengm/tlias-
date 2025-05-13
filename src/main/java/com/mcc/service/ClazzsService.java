package com.mcc.service;

import com.mcc.pojo.Clazzs;
import com.mcc.pojo.ClazzsQueryParam;
import com.mcc.pojo.PageResult;

import java.util.List;

public interface ClazzsService {
    PageResult<Clazzs> page(ClazzsQueryParam clazzsQueryParam);

    void deleteById(Integer id);

    void save(Clazzs clazzs);

    Clazzs getInfo(Integer id);

    void update(Clazzs clazzs);

    List<Clazzs> list();
}
