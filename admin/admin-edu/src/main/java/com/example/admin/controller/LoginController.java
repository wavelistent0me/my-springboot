package com.example.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.admin.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.admin.entity.User;
import com.example.admin.service.IUserService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    IUserService userService;

    /**
     * 登录
     */
    @RequestMapping("/admin/login")
    public String login(User user)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", user.getUsername());
        User selectUser = userService.getOne(wrapper);

        if (selectUser != null) {
            System.out.println(selectUser.getPassword());
            System.out.println(user.getPassword());
            System.out.println(selectUser.getPassword() == user.getPassword());
            if (selectUser.getPassword().equals(user.getPassword())) {
                String token = JwtUtil.createToken(user);
                return token;
            }
            else {
                return "账号密码错误";
            }
        }
        else {
            return "用户不存在";
        }
    }
}
