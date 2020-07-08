package com.mitbook.service;
import com.mitbook.entity.UserEntity;
import java.util.List;
/**
 * @author pengzhengfa
 */
public interface UserService {

    List<UserEntity> selectAllUser();

    List<UserEntity> selectAllIdUser(Integer id);

    int insertUserData(UserEntity userEntity);

    int updateUserData(UserEntity userEntity);

    int  deleteUserById(UserEntity userEntity);
}
