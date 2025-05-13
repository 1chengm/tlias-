package com.mcc.mapper;

import com.mcc.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface EmpExprMapper {

    /**
     * 增加工作经历数据
     */
    void insertBatch( List<EmpExpr> exprList);

    /**
     * 根据员工的ID批量删除工作经历信息
     */
    void deleteByEmpIds(List<Integer> empIds);
}
