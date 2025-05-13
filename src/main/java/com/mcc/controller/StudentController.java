package com.mcc.controller;


import com.github.pagehelper.PageHelper;
import com.mcc.pojo.PageResult;
import com.mcc.pojo.Result;
import com.mcc.pojo.StuQueryParam;
import com.mcc.pojo.Student;
import com.mcc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StuQueryParam stuQueryParam){

        PageResult<Student> pageResult = studentService.page(stuQueryParam);

        return Result.success(pageResult);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids){
        studentService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Student student) {
        studentService.save(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }
    @PutMapping
    public Result update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        studentService.violation(id, score);
        return Result.success();
    }
}