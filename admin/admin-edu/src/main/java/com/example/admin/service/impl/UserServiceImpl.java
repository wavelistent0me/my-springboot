package com.example.admin.service.impl;

import com.example.admin.entity.User;
import com.example.admin.mapper.UserMapper;
import com.example.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wave
 * @since 2022-10-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
