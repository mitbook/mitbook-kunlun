package com.mitbook.mapper;
import com.mitbook.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author pengzhengfa
 */

@Mapper
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
