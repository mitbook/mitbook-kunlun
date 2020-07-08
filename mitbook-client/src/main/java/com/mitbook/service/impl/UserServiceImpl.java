package com.mitbook.service.impl;
import com.mitbook.entity.UserEntity;
import com.mitbook.mapper.UserMapper;
import com.mitbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengzhengfa
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<UserEntity> selectAllIdUser(Integer id) {
        return userMapper.selectAllIdUser(id);
    }

    @Override
    public int insertUserData(UserEntity userEntity) {
        return userMapper.insertUserData(userEntity);
    }

    @Override
    public int updateUserData(UserEntity userEntity) {
        return userMapper.updateUserData(userEntity);
    }

    @Override
    public int deleteUserById(UserEntity userEntity) {
        return userMapper.deleteUserById(userEntity);
    }
}
