package com.mcc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazzs {

    private Integer id;
    private String name;//班级名称
    private String room;//教室
    private LocalDate beginDate;//开班日期
    private LocalDate endDate;//结课日期
    private Integer MasterId;
    private Integer Subject;//课程
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间

    private Integer status; //状态 未开班，已开班，已结课
    private String masterName;//班主任姓名
}
