package com.codeking.admin.config;

import com.codeking.admin.ContextListener.MyServletContextListener;
import com.codeking.admin.filter.MyFilter;
import com.codeking.admin.interceptor.LoginInterceptor;
import com.codeking.admin.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author : codeking
 * @create : 2022/12/13 11:28
 */
// 这个得单例，要不然每次都new一个servlet的话，会存在很多信息的冗余
@Configuration(proxyBeanMethods = true)
public class AdminWebConfig implements WebMvcConfigurer {

    // 注入原生的servlet
    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/my");
    }

    // 注入filter
    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
//        return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
        return filterRegistrationBean;
    }

    // 注入监听器
    @Bean
    public ServletListenerRegistrationBean myListener() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器 拦截器会拦截所有，需要配置不拦截的静态资源
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //全部拦截，然后在底下放行部分请求
                .excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/js/**", "/", "/table/**", "/form/**", "/login", "/logout","/savaPerson");
    }
}
