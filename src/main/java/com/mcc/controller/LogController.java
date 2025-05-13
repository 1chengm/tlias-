package com.mcc.controller;


import com.mcc.pojo.OperateLog;
import com.mcc.pojo.PageResult;
import com.mcc.pojo.Result;
import com.mcc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/log/page")
    public Result Page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageResult<OperateLog> pageResult = logService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
