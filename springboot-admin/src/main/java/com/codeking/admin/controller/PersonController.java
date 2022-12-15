package com.codeking.admin.controller;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeking.admin.bean.Person;
import com.codeking.admin.mapper.PersonMapper;
import com.codeking.admin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author : codeking
 * @create : 2022/12/15 22:55
 */
@Controller
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonMapper personMapper;

    @GetMapping("/getPerson")
    public String getPerson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //表格内容的遍历
        //从数据库中查出user表中的用户进行展示
        //构造分页参数
        Page<Person> page = new Page<>(pn, 2);
        //调用page进行分页
        Page<Person> userPage = personService.page(page, null);
        model.addAttribute("users", userPage);
        return "/mian";
    }

    @ResponseBody
    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson() {
        // 查询所有
        List<Person> people = personMapper.selectList(null);
        return people;
    }
    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        personService.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
}