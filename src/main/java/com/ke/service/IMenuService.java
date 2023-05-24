package com.ke.service;

import com.ke.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ke
 * @since 2022-02-15
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> findMenus(String name);
}
