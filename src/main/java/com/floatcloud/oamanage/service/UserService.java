package com.floatcloud.oamanage.service;

import com.floatcloud.oamanage.entity.UserEntity;

/**
 * 用户相关操作接口
 * @author f1593
 */
public interface UserService {

    /**
     * 根据UserName 查询用户信息
     * @param userName 用户名
     * @return 返回用户信息
     */
    UserEntity findUserMsgByUserName(String userName);
}
