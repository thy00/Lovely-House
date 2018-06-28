package cn.thyonline.house.biz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 10:39
 */
@Configuration
public class DruidConfig {

    /**
     * 配置druid
     * @return
     */
    @ConfigurationProperties(prefix = "spring.druid")//作用：1、绑定此数据到bean。2、将返回对象和配置文件绑定
    @Bean(initMethod = "init",destroyMethod = "close")//定义开启和关闭时间
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));//将慢日志添加到了功能里面
        return dataSource;
    }

    /**
     * 打印慢日志
     * @return
     */
    @Bean
    public Filter statFilter(){
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);//毫秒
        filter.setLogSlowSql(true);//是否打印慢日志
        filter.setMergeSql(true);//是否将日志合并
        return filter;
    }

    /**
     * 配置监听器
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }
}
