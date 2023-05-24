package com.ke.mapper;

import com.ke.controller.dto.UserPasswordDTO;
import com.ke.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ke
 * @since 2022-02-12
 */
public interface UserMapper extends BaseMapper<User> {

    @Update("update user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);
}
