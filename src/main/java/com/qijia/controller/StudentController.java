package com.qijia.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qijia.domain.Result;
import com.qijia.domain.Student;
import com.qijia.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "学生类接口")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //插入一条记录
    @PostMapping("/students")
    @ApiOperation(value = "插入一条记录")
    public Result insert(@RequestBody Student student) {
        student = studentService.insert(student);
        if (student.getId() != null) {
            return new Result(true, student, "操作成功");
        } else {
            return new Result(false, null, "操作失败");
        }
    }
    //根据主键删除
    @DeleteMapping("/students/{id}")
    @ApiOperation(value = "根据主键删除")
    public Result deleteById(@PathVariable("id") String id) {
        Integer rows = studentService.deleteById(id);
        if (rows > 0) {
            return new Result(true, rows, "操作成功");
        } else {
            return new Result(false, rows, "操作失败");
        }
    }

    //根据主键修改
    @PutMapping("/students")
    @ApiOperation(value = "根据主键修改")
    public Result updateById(@RequestBody Student student) {
        Integer rows = studentService.updateById(student);
        if (rows > 0) {
            return new Result(true, rows, "操作成功");
        } else {
            return new Result(false, rows, "操作失败");
        }
    }

    //根据主键查找
    @GetMapping("/common/students/{id}")
    @ApiOperation(value = "根据主键查找")
    public Result selectById(@PathVariable("id") String id) {
        Student student = studentService.selectById(id);
        if (student != null) {
            return new Result(true, student, "操作成功");
        } else {
            return new Result(false, null, "操作失败");
        }
    }

    //根据条件查找
    @PostMapping("/common/students/page")
    @ApiOperation(value = "根据条件查找")
    public Result search(@RequestBody Map<String, Object> searchMap) {
        Page<Student> userPage = studentService.search(searchMap);
        if (userPage != null) {
            return new Result(true, userPage, "操作成功");
        } else {
            return new Result(false, null, "操作失败");
        }
    }

}
