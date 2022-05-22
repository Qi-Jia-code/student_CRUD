package com.qijia.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qijia.domain.Student;

import java.util.Map;

public interface StudentService {
    //插入一条记录
    public Student insert(Student student);

    //根据主键删除
    public Integer deleteById(String id);

    //根据主键修改
    public Integer updateById(Student student);

    //根据主键查找
    public Student selectById(String id);

    //根据条件查找
    public Page<Student> search(Map<String,Object> searchMap);
}
