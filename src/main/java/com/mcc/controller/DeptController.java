package com.mcc.controller;


import com.mcc.pojo.Dept;
import com.mcc.pojo.Result;
import com.mcc.service.DeptService;


import com.mcc.service.EmpService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController//返回的集合或者列表转换为json格式
public class DeptController {

    //定义日志记录对象
    //常规定义
//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private  DeptService deptService;

    @Autowired
    private EmpService empService;
    /**
     * 查询部门列表
     */
    @GetMapping
    public Result list(){
//        log.info("查询所有部门列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id ) {
        if ( empService.getByDeptId(id) != null){
            return Result.error("该部门下有员工，无法删除");
        }
//        log.info("根据id删除部门: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
       return Result.success();
    }

    /**
     *
     * 通过id查询回显,pathvarible(id)
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);

        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);

        return Result.success();
    }
}
