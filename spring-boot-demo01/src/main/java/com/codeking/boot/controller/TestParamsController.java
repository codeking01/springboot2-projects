package com.codeking.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : codeking
 * @create : 2022/12/11 16:46
 */
@Controller
public class TestParamsController {
    //@GetMapping("/test")
    //public String testPage() {
    //    return "/test.html";
    //}

    @GetMapping("/car/{id}/owner/{username}")
    @ResponseBody
    public Map<String, Object> testParams(@PathVariable("id") Integer id,
                                          @PathVariable("username") String username,
                                          @PathVariable Map<String, String> pv,
                                          @RequestHeader("User-Agent") String requestUserAgent,
                                          @CookieValue("Idea-2fb67f76") Cookie cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);
        map.put("User-Agent", requestUserAgent);
        map.put("Cookie", cookie);
        return map;
    }

    /*  @MatrixVariable 矩阵变量  可以解决session禁用的问题
        url 重写： /abc;jsessionid=**** 把cookie的值放这里
        1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
        2、SpringBoot默认是禁用了矩阵变量的功能  当前我使用的这个2.6.11没有禁用，以前是需要添加组件或者实现webMvcConfiguration类
        手动幵启：原理。对于路径的处理。UrlPathHelper进行解析。
        removeSemicolonContent (移除分号内容）支持矩阵变量的
        3、矩阵变量必须有url路径变量才能被解析
    */
    @GetMapping("/boss/{bossId}/{employeeId}")
    @ResponseBody
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "employeeId") Integer empAge
                                    /*,@PathVariable("bossId") String bossId,
                                    @PathVariable("employeeId") String employeeId*/) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        // 同时写两个没拿到
        //System.out.println("bossId"+bossId);
        //System.out.println("employeeId"+employeeId);
        return map;
    }
}
