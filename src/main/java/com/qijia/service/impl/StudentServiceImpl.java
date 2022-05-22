package com.qijia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qijia.domain.Student;
import com.qijia.mapper.StudentMapper;
import com.qijia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public Student insert(Student student) {
        studentMapper.insert(student);
        return student;
    }

    @Override
    public Integer deleteById(String id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public Integer updateById(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public Student selectById(String id) {
        return studentMapper.selectById(id);
    }

    @Override
    public Page<Student> search(Map<String, Object> searchMap) {
        //定义查询参数
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer pageNum = 1;
        Integer pageSize = 20;
        Map<String, String> orderEntity = null;
        Map<String, String> searchEntity = null;
        //接收查询参数
        if (searchMap.get("pageNum") != null) {
            pageNum = (Integer) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (Integer) searchMap.get("pageSize");
        }
        if (searchMap.get("orderEntity") != null) {
            orderEntity = (Map<String, String>) searchMap.get("orderEntity");
            Set<Map.Entry<String, String>> OrderEntries = orderEntity.entrySet();
            for (Map.Entry<String, String> entry : OrderEntries) {
                String orderByColumn = entry.getKey();
                String orderByValue = entry.getValue();
                if ("asc".equals(orderByValue)) {
                    queryWrapper.orderByAsc(orderByColumn);
                } else {
                    queryWrapper.orderByDesc(orderByColumn);
                }
            }
        }
        if (searchMap.get("searchEntity") != null) {
            searchEntity = (Map<String, String>) searchMap.get("searchEntity");
            //查询主键列
            if (searchEntity.get("id") != null) {
                queryWrapper.eq("id", searchEntity.get("id"));
            }
            //查询普通列
            if (searchEntity.get("name") != null) {
                queryWrapper.like("name", searchEntity.get("name"));
            }
            if (searchEntity.get("sex") != null) {
                queryWrapper.like("sex", searchEntity.get("sex"));
            }
            if (searchEntity.get("major") != null) {
                queryWrapper.like("major", searchEntity.get("major"));
            }
            if (searchEntity.get("phone") != null) {
                queryWrapper.like("phone", searchEntity.get("phone"));
            }
        }
        //创建分页对象
        Page<Student> page = new Page<>(pageNum, pageSize);
        //返回查询结果
        Page<Student> userPage = studentMapper.selectPage(page, queryWrapper);
        return userPage;
    }
}
