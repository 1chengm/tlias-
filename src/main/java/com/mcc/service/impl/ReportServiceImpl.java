package com.mcc.service.impl;

import com.mcc.mapper.EmpMapper;
import com.mcc.mapper.StudentMapper;
import com.mcc.pojo.JobOption;
import com.mcc.pojo.StuOption;
import com.mcc.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> countEmpGenderData() {
       return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map> countStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public StuOption countStudentCountData() {

       List<Map<String,Object>> list = studentMapper.countStudentCountData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazz")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new StuOption(clazzList, dataList);
    }

}
