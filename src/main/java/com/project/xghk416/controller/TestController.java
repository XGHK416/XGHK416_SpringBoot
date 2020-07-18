package com.project.xghk416.controller;

import com.project.xghk416.result.Result;
import com.project.xghk416.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @PostMapping("/test1")
    public Result test1(){
        return ResultUtil.success();
    }
}
