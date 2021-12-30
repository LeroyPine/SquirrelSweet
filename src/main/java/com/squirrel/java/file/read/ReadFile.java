package com.squirrel.java.file.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadFile {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\松鼠\\Desktop\\work.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, ReadDemo.class, new PageReadListener<ReadDemo>(dataList -> {
            for (ReadDemo demoData : dataList) {

                System.out.println("//" + demoData.getRemark() + "");
                System.out.println("private " + demoData.getType() + " " + demoData.getParam() + ";");
            }
        })).sheet().doRead();
    }
}
