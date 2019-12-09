package com.neoway.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 20190712713
 * @date 2019/12/7 15:30
 */
@Controller
public class FileUploadController {


    @PostMapping(value = "/upload")
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException{

            byte[] bytes = file.getBytes();
            File fileToSave = new File(file.getOriginalFilename());
            FileCopyUtils.copy(bytes,fileToSave);

            return fileToSave.getAbsolutePath();
    }
}
