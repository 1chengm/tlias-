package com.mcc.pojo;

import lombok.Data;

@Data
public class StuQueryParam {
    private String name;
    private String degree;
    private String clazzId;
    private Integer Page = 1;
    private Integer PageSize = 10;
}
