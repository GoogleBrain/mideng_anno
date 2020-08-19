package cn.k.mideng_anno.anno;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Component
public class MyConfigurer implements WebMvcConfigurer {

    @Resource
    private MyToken myToken;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myToken).addPathPatterns("/**");
    }
}
