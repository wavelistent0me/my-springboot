package com.example.admin.controller;


import com.example.admin.Entity.Player;
import com.example.admin.Mapper.PlayerMapper;
import com.example.admin.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

