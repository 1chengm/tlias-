package com.mcc.controller;

import com.mcc.pojo.JobOption;
import com.mcc.pojo.Result;
import com.mcc.pojo.StuOption;
import com.mcc.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    //查询员工职位统计数据
    @GetMapping("/empJobData")
    public Result getEmpJobData() {

        JobOption jobOption =  reportService.getEmpJobData();
    return Result.success(jobOption);
    }
    //查询员工性别统计数据
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        List<Map> genderList = reportService.countEmpGenderData();
        return Result.success(genderList);
    }
    //查询学生学历统计数据
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        List<Map> degreeList = reportService.countStudentDegreeData();

        return Result.success(degreeList);
    }
    //查询学生人数统计数据
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        StuOption countList = reportService.countStudentCountData();
        return Result.success(countList);
    }
}

