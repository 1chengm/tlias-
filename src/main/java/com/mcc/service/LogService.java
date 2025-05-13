package com.mcc.service;

import com.mcc.pojo.OperateLog;
import com.mcc.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> page(Integer pageNo, Integer pageSize);

}
