package com.example.admin.controller;


import com.example.admin.Entity.Player;
import com.example.admin.Mapper.PlayerMapper;
import com.example.admin.config.User;
import com.example.admin.service.IPlayerService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wave
 * @since 2022-10-14
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/player")
public class PlayerController {

    @Resource
    PlayerMapper playerMapper;
    @Autowired
    IPlayerService playerService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/testSelect")
    public void testSelect() {
        List<Player> playerList = playerMapper.selectList(null);
        playerList.forEach(System.out::println);
    }

    //查询所有Player
    @GetMapping("findAllPlayer")
    public List<Player> FindAllPlayer() {
        return playerService.list(null);
    }

    @GetMapping("/index")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("User", user);
        return "index";
    }

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
    }
}

