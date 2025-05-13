package com.mcc.controller;

import com.mcc.pojo.Emp;
import com.mcc.pojo.EmpQueryParam;
import com.mcc.pojo.PageResult;
import com.mcc.pojo.Result;
import com.mcc.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/emps")

public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {

            log.info("查询信息 {}", empQueryParam);
            PageResult<Emp> pageResult =  empService.page(empQueryParam);
            return Result.success(pageResult);
    }

    @PostMapping
    @Transactional(rollbackFor = {Exception.class})

    public Result save(@RequestBody Emp emp) {//json记得绑定到类对象上，否则会报错
        log.info("请求保存信息:{}",emp);
        empService.save(emp);
        return Result.success();
    }
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("请求删除信息:{}",ids);
        empService.delete(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {

        log.info("请求查询信息:{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    @GetMapping("/list")
    public Result list() {
        log.info("请求查询所有信息");
        List<Emp> list = empService.list();
        return Result.success(list);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("请求更新信息:{}",emp);
        empService.update(emp);

        return Result.success();
    }
}
