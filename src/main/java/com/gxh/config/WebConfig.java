package com.gxh.config;

import com.gxh.controller.interceptors.MyFstInterceptor;
import com.gxh.controller.interceptors.MySecInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableWebMvc//使用此注解会替代掉SpringBoot自动配置的一些组件，导致比如无法访问静态资源的问题
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyFstInterceptor myFstInterceptor;

    @Autowired
    private MySecInterceptor mySecInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myFstInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(mySecInterceptor).addPathPatterns("/**");
    }

//    @Bean
//    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setResolveLazily(true);
//        resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(50*1024*1024);
//        return resolver;
//    }

}
