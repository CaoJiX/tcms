package com.ke.service;

import com.ke.controller.dto.UserDTO;
import com.ke.controller.dto.UserPasswordDTO;
import com.ke.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ke
 * @since 2022-02-12
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);

}
