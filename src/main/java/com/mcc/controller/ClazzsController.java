package com.mcc.controller;

import com.mcc.anno.LogOperation;
import com.mcc.pojo.Clazzs;
import com.mcc.pojo.ClazzsQueryParam;
import com.mcc.pojo.PageResult;
import com.mcc.pojo.Result;
import com.mcc.service.ClazzsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClazzsController {

    @Autowired
    private ClazzsService clazzsService;

    @GetMapping
    public Result page(ClazzsQueryParam clazzsQueryParam) {
        log.info("分页查询，参数：{}", clazzsQueryParam);
        PageResult<Clazzs> pageResult = clazzsService.page(clazzsQueryParam);
        return Result.success(pageResult);
    }

    @LogOperation
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {//如果id与参数名不一致，需要在@PathVariable中指定参数名
        log.info("路径删除，路径名:{}", id);
        clazzsService.deleteById(id);
        return Result.success();
    }
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Clazzs clazzs) {
        log.info("新增{}", clazzs);
        clazzsService.save(clazzs);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据id查询{}", id);
        Clazzs clazzs = clazzsService.getInfo(id);
        return Result.success(clazzs);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Clazzs clazzs) {
        log.info("修改{}", clazzs);
        clazzsService.update(clazzs);
        return Result.success();
    }
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有");
        List<Clazzs> clazzsList = clazzsService.list();
        return Result.success(clazzsList);
    }
}
