package com.unicom.smartcity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author liukai
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("user: {}", user);
        return "index";
    }

    @PostMapping("/file")
    public void file(@RequestParam(name = "file") MultipartFile file) {


        try {
            InputStream inputStream = file.getInputStream();

            OutputStream outputStream = new FileOutputStream(new File("F:\\" + file.getOriginalFilename()));

            byte[] b = new byte[1024];

            byte[] content = new byte[1024];

            while (inputStream.read(b) != -1) {
                outputStream.write(b);
            }


            outputStream.close();

            inputStream.close();


            System.out.println("inputStream = " + inputStream);
        } catch (IOException e) {
            log.error("上传文件出错", e);
        }

    }

}
