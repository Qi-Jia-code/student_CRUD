package com.qijia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qijia.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
