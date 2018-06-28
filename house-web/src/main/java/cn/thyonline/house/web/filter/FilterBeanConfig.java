package cn.thyonline.house.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @Description:包装filter成为bean
 * @Author: Created by thy
 * @Date: 2018/6/28 0:32
 */
@Configuration
public class FilterBeanConfig {

    /**
     * 构造拦截对象
     * @return
     */
    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LogFilter());
        //构建需要拦截对象的路径集合
        ArrayList<String> urls = new ArrayList<>();
        urls.add("*");//拦截所有
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }
}
