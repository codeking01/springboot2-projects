package com.codeking.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author : codeking
 * @create : 2022/12/13 21:56
 */
@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "/form/form_layouts";
    }
    @PostMapping("/upload")
    public String formController(@RequestParam("email") String email,
                                 @RequestParam("username") String username,
                                 @RequestPart("headerImg") MultipartFile headerImg,
                                 @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",
                email, username, headerImg.getSize(), photos.length);
        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\All_Cache\\files\\"+originalFilename));
        }
        for (MultipartFile photo : photos) {
            String originalFilename = photo.getOriginalFilename();
            photo.transferTo(new File("D:\\All_Cache\\files\\" + originalFilename));
        }
        return "redirect:/mian";
    }
}
