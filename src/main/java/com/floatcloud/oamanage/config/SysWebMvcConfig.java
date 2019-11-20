package com.floatcloud.oamanage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.floatcloud.oamanage.intercept.LoginInterceptor;

/**
 * SysWebMvcConfig
 * SpringBootWeB服务 Mvc 配置文件
 * 2.0后，不再使用其适配器(WebMvcConfigurerAdapter已过时)进行配置
 * @auther FloatCloud
 * @date 2019/11/20
 */
@Configuration
public class SysWebMvcConfig implements WebMvcConfigurer{


    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * ResourceHandlers 资源处理器
     * 向SpringBoot配置中，添加资源目录配置
     * addResourceHandler: 添加资源处理器（请求URL）
     * addResourceLocations: 添加对应的本地资源目录（请求URL对应的物理地址）
     * @param registry 资源处理器注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    /**
     * Interceptors 拦截器
     * 2.0后，拦截器会拦截静态资源目录下的资源
     * 所以/static/**，该设置为addResourceHandlers添加的资源处理器
     * 效果：不拦截classpath:/static/包下所有资源
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/login")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/static/**");
    }

    /**
     * Configure simple automated controllers pre-configured with the response
     * status code and/or a view to render the response body. This is useful in
     * cases where there is no need for custom controller logic -- e.g. render a
     * home page, perform simple site URL redirects, return a 404 status with
     * HTML content, a 204 with no content, and more.
     * 配置一些简单的请求响应的视图解析器；用于主页，执行简单的站点URL重定向，返回404状态
     * 简单HTML内容，204没有内容等
     * @param registry 视图解析器注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 首页视图解析器
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/login.html").setViewName("/login");
    }
}
