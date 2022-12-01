package com.example.demo.controller;

import com.example.demo.bean.TestPerson;
import com.example.demo.controller.respbean.RespBean;
import com.example.demo.controller.respbean.RespBeanBuilder;
import com.example.demo.service.StudentService;
import com.example.demo.util.ValidationUtils;
import com.example.demo.util.XLSXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Controller
public class TestPersonController {

    @Autowired
    private StudentService service;


    /**
     * 默认跳转到
     */
    @GetMapping("/")
    public String toFirstHtml(){
        return "studentpage";
    }


    /**
     * 下载模板
     */
    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response) throws UnsupportedEncodingException, FileNotFoundException {

        File file  = ResourceUtils.getFile("classpath:xlsxtemplate/sjmb.xlsx");
        String fileName = file.getName(); //下载的文件名

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
                catch (Exception e) {
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


    /**
     * 上传记录
     */
    @PostMapping(value = "/upload")
    public RespBean uploadFile(@RequestParam("fileUpload") MultipartFile file){

        //调用工具类解析excel文件
        ArrayList<TestPerson> students = XLSXUtils.analysis(file);

        //文件校验并移除
        Iterator it =students.iterator();
        while (it.hasNext()){
            TestPerson person = (TestPerson) it.next();
            Set<ConstraintViolation<TestPerson>> set = ValidationUtils.validation(person);
            if(!set.isEmpty()){
                it.remove();
            }
        }

        //入库 & 校验
        int successNum = service.importData(students);

        RespBeanBuilder<Integer> respBeanBuilder = new RespBeanBuilder<>();
        return respBeanBuilder.addCode(1).addMsg("上传成功").addData(successNum).bulid();
    }

    /**
     * 下载记录
     */
    @GetMapping("/list")
    @ResponseBody
    public RespBean getList() throws ParseException {
        //解析条件
        List<TestPerson> students =  service.getList();
        RespBeanBuilder<List<TestPerson>> respBeanBuilder = new RespBeanBuilder<>();
        return respBeanBuilder.addCode(1).addMsg("上传成功").addData(students).bulid();
    }
}
