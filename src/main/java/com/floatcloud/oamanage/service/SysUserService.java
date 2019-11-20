package com.floatcloud.oamanage.service;

import java.util.List;

import com.floatcloud.oamanage.entity.SysUser;

/**
 * SysUserService
 * 应用层：用户相关操作
 * @auther FloatCloud
 * @date 2019/11/20
 */
public interface SysUserService {

    /**
     * 根据userName获取用户信息
     * @param userName 用户名
     * @return 用户对象
     */
    SysUser findUserByUserName(String userName);

    /**
     * 查询所有用户信息
     * @return 用户对象集合
     */
    List<SysUser> findAllUser();

}
