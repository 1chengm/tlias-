package com.mcc.pojo;

import com.github.pagehelper.Page;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzsQueryParam {
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    private Integer Page = 1;
    private Integer PageSize = 10;

}
