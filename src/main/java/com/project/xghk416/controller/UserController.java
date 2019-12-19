package com.project.xghk416.controller;


import com.project.xghk416.pojo.po.UserPo;
import com.project.xghk416.result.Result;
import com.project.xghk416.service.UserService;
import com.project.xghk416.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping(value = "/test1")
    public Result testResult(String name,String password){

        UserPo userPo = userService.getById(1);

        Result result= ResultUtil.success(userPo);
        return result;
    }

}
