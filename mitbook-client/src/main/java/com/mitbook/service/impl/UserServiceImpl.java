/*
 * Copyright 1999-2020 Mitbook Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class UserServiceImpl implements UserService {

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
