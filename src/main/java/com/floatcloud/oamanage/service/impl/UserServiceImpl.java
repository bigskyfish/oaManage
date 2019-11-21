package com.floatcloud.oamanage.service.impl;

import com.floatcloud.oamanage.entity.UserEntity;
import com.floatcloud.oamanage.service.UserService;

/**
 * 应用层：用户相关操作实现类
 * @author f1593
 */
public class UserServiceImpl implements UserService {


    @Override
    public UserEntity findUserMsgByUserName(String userName) {
        UserEntity userInfo = new UserEntity();
        userInfo.setUserName(userName);
        return userInfo;
    }
}
