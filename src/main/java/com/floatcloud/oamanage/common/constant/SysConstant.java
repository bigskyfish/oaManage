package com.floatcloud.oamanage.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * SysConstant
 *
 * @auther FloatCloud
 * @date 2019/11/20
 */
@Component
@PropertySource({"classpath:/sysConstant.properties"})
public class SysConstant {

    @Value("${sys.sessionUserName}")
    public String sessionUserName;


    public String getSessionUserName() {
        return sessionUserName;
    }


}
