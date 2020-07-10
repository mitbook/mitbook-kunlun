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
package com.mitbook.mapper;

import com.mitbook.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author pengzhengfa
 */
public interface UserMapper {

    @Select("select id,name from user")
    List<UserEntity> selectAllUser();

    @Select("select id,name from user where id=#{id}")
    List<UserEntity> selectAllIdUser(Integer id);

    @Insert("insert into user (id,name) values (#{id},#{name})")
    int insertUserData(UserEntity userEntity);


    @Update("update user set name=#{name} where id=#{id}")
    int updateUserData(UserEntity userEntity);


    @Delete("delete from user where id=#{id}")
    int deleteUserById(UserEntity userEntity);

}
