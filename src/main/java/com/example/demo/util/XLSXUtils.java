package com.example.demo.util;

import com.example.demo.bean.TestPerson;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

@Slf4j
public class XLSXUtils {

    /**
     * 解析xlsx文件
     */
    public static ArrayList<TestPerson> analysis(MultipartFile file) {
        ArrayList<TestPerson> students = new ArrayList<>();
        //获取文件名称
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        InputStream in = null;
        try {
            //获取输入流
            in = file.getInputStream();
            Workbook workbook =new XSSFWorkbook(in);

            //获取第一张工作表
            Sheet sheet = workbook.getSheetAt(0);
            //从第二行开始获取
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                //循环获取工作表的每一行
                Row sheetRow = sheet.getRow(i);
                //循环获取每一列
                TestPerson cell = new TestPerson();
                for (int j = 0; j < sheetRow.getPhysicalNumberOfCells(); j++) {
                    try {
                        //可能有转换异常问题,处理掉
                        String value = sheetRow.getCell(j).getStringCellValue();
                        //主键默认让系统生成
                        if(j == 1){
                            cell.setName(value);
                        }

                        if(j == 2&& value !=null && "" != value){
                            cell.setSex(Integer.valueOf(value));
                        }
                        if(j == 3){
                            cell.setSfzh(value);
                        }
                        if(j == 4&& value !=null && "" != value){
                            cell.setHeight(Double.valueOf(value));
                        }
                        if(j == 5&& value !=null && "" != value){
                            cell.setWeight(Double.valueOf(value));
                        }
                        if(j == 6&& value !=null && "" != value){
                            cell.setRksj(Date.valueOf(value));
                        }
                    }catch (Exception e){
                        cell = null;
                    }

                }
                //将装有每一列的集合装入大集合
                if(cell != null){
                    students.add(cell);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("===================未找到文件======================");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("===================上传失败======================");
        } finally {
            //关闭资源
            if(in !=null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
        return students;
    }
}
