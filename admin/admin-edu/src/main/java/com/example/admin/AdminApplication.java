package com.example.admin;

import com.example.admin.config.User;
/*import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
//@MapperScan("com.example.Admin.Mapper")
@ServletComponentScan(basePackages = "com.example.admin.jwt")//为使过滤器生效,添加此注释
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


    /*@GetMapping("/index")*/
    /*public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("User", user);
        return "index";
    }*/

/*
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        try {
            //执行登录
            subject.login(token);
            return "ok";
        } catch (UnknownAccountException e) {
            return e.getMessage();
        } catch (IncorrectCredentialsException e) {
            return "IncorrectCredentialsException " + e.getMessage();
        } catch (LockedAccountException e) {
            return "LockedAccountException " + e.getMessage();
        } catch (AuthenticationException e) {
            return "认证失败！";
        }
    }*/
}
