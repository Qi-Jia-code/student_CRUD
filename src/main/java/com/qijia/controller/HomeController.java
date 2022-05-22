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
public class HomeController {
    @GetMapping("/")
    public String homePage() {
            return "index";
    }
}