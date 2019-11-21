package com.floatcloud.oamanage.config;

import com.floatcloud.oamanage.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author f1593
 */
@Configuration
public class SysWebMvcConfigurer implements WebMvcConfigurer {


    /**
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true).setUseTrailingSlashMatch(true);

    }

    /**
     * 添加视图映射路径
     * @param registry 视图控制注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

    /**
     * 注册过滤器
     * @param registry 过滤器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/static/**");
    }

    /**
     *  SpringBoot 2.0后，添加拦截器，会过滤掉静态资源的请求
     *  通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径。
     *  @param registry 静态资源注册器
     *  addResourceLocations指的是文件放置的目录，
     *  addResourceHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
