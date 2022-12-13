package com.codeking.admin.servlet;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * @author : codeking
 * @create : 2022/12/14 0:33
 */

/**
 * 定制化的常见方式
 * <p>
 * * 修改配置文件
 * <p>
 * * `xxxxxCustomizer`
 * <p>
 * * 编写自定义的配置类 `xxxConfiguration` + `@Bean`替换、增加容器中默认组件，视图解析器
 * <p>
 * * Web应用 编写一个配置类实现 `WebMvcConfigurer` 即可定制化web功能 + `@Bean`给容器中再扩展一些组件
 * <p>
 * `@EnableWebMvc` + `WebMvcConfigurer` — `@Bean` 可以全面接管SpringMVC，所有规则全部自己重新配置； 实现定制和扩展功能（**高级功能，初学者退避三舍**）。
 * <p>
 * * 原理：
 * 1. `WebMvcAutoConfiguration`默认的SpringMVC的自动配置功能类，如静态资源、欢迎页等。
 * 2. 一旦使用 `@EnableWebMvc` ，会`@Import(DelegatingWebMvcConfiguration.class)`。
 * 3. `DelegatingWebMvcConfiguration`的作用，只保证SpringMVC最基本的使用
 * * 把所有系统中的`WebMvcConfigurer`拿过来，所有功能的定制都是这些`WebMvcConfigurer`合起来一起生效。
 * * 自动配置了一些非常底层的组件，如`RequestMappingHandlerMapping`，这些组件依赖的组件都是从容器中获取如。
 * * `public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport`。
 * 4. `WebMvcAutoConfiguration`里面的配置要能生效必须 `@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)`。
 * 5. @EnableWebMvc 导致了WebMvcAutoConfiguration 没有生效。
 */
@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(9000);
    }
}
