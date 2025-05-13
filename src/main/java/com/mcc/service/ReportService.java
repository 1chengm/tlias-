package com.mcc.service;


import com.mcc.pojo.JobOption;
import com.mcc.pojo.StuOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {
    JobOption getEmpJobData();

    List<Map> countEmpGenderData();

    List<Map> countStudentDegreeData();

    StuOption countStudentCountData();
}
