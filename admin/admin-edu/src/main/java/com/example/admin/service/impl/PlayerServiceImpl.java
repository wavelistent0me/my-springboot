package com.example.admin.service.impl;

import com.example.admin.service.IPlayerService;
import com.example.admin.Entity.Player;
import com.example.admin.Mapper.PlayerMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wave
 * @since 2022-10-14
 */
@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerService {

}
