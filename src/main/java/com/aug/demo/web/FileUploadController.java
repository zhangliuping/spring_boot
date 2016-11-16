package com.aug.demo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.aug.demo.exception.ServiceException;

@Controller
public class FileUploadController {

    @RequestMapping("/file")
    public String file() {
        return "/file";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "You failed to upload because the file was empty.";
        }
        // 1、文件路径; 2、文件名; 3、文件格式; 4、文件大小的限制;
        try {
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(new File(file.getOriginalFilename())));
            out.write(file.getBytes());
            out.flush();
            out.close();
            return "Upload successful";
        } catch (IOException e) {
            throw new ServiceException("Upload file failure, " + e.getMessage());
        }
    }

    @RequestMapping("/mutifile")
    public String mutifile() {
        return "/mutifile";
    }

    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleBatchFileUpload(HttpServletRequest request) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> files = multiRequest.getFiles("file");
            try {
                MultipartFile file = null;
                BufferedOutputStream stream = null;
                for (int i = 0; i < files.size(); ++i) {
                    file = files.get(i);
                    if (file.isEmpty()) {
                        continue;
                    }

                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                }
                return "Batch upload successful";
            } catch (IOException e) {
                throw new ServiceException("Batch upload files failure, " + e.getMessage());
            }
        } else {
            throw new ServiceException("Invalid enctype. ");
        }

    }
}
