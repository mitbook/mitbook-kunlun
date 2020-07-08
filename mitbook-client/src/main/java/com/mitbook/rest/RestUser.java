package com.mitbook.rest;
import com.mitbook.annotation.RequestMapping;
import com.mitbook.annotation.RequestParam;
import com.mitbook.annotation.RestController;
import com.mitbook.entity.UserEntity;
import com.mitbook.response.GeneralResponse;
import com.mitbook.service.UserService;
import com.mitbook.utils.SpringContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
/**
 * @author pengzhengfa
 */
@RestController
public class RestUser {


    private static final UserService userService = SpringContextHolder.getBean(UserService.class);

    /**
     * 无条件查询（查询所有的用户）
     * @return
     */
    @RequestMapping(uri = "findAllUser")
    public GeneralResponse findAllUser() {
         List<UserEntity> userList = userService.selectAllUser();
        return GeneralResponse.success(userList);
    }

    /**
     * 有条件查询(据主键查询用户)
     * @param id
     * @return
     */
    @RequestMapping(uri = "findUserById")
    public GeneralResponse findAllIdUser(@RequestParam(name = "id") Integer id) {
        List<UserEntity> userList =userService.selectAllIdUser(id);
        return GeneralResponse.success(userList);
    }


    /**
     * 插入（录入数据）
     * @param userEntity
     * @return
     */
    @RequestMapping(uri = "insertUserData",method = RequestMethod.POST)
    public GeneralResponse insertUserData(@RequestBody UserEntity userEntity) {
        int insertUserData = userService.insertUserData(userEntity);
        return GeneralResponse.success(insertUserData);
    }


    /**
     * 更改用户信息
     * @param userEntity
     * @return
     */
    @RequestMapping(uri = "updateUserById",method = RequestMethod.POST)
    public GeneralResponse updateUserById(@RequestBody UserEntity userEntity) {
        int updateUserData = userService.updateUserData(userEntity);
        return GeneralResponse.success(updateUserData);
    }
    /**
     * 冻结用户信息
     * @param userEntity
     * @return
     */
    @RequestMapping(uri = "deleteUserById",method = RequestMethod.POST)
    public GeneralResponse deleteUserById(@RequestBody UserEntity userEntity) {
        int deleteUserById = userService.deleteUserById(userEntity);
        return GeneralResponse.success(deleteUserById);
    }
}
