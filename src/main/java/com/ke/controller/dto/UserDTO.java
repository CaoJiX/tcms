package com.ke.controller.dto;

import com.ke.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {

    private Integer id;

    private String username;
    private String password;
    private String nickname;
    private String token;
    private String role;

    private List<Menu> menus;
}
