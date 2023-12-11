package com.squirrel.java.file.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ReadFile {

    public static void main(String[] args) {
        String fileName = "/Users/luobaosong/Downloads/南昌消息.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行

        Set<String>  houseidSet = new HashSet<>();
        EasyExcel.read(fileName, ReadDemo.class, new PageReadListener<ReadDemo>(dataList -> {
            for (ReadDemo demoData : dataList) {



                JSONArray jsonArray = JSON.parseArray( demoData.getType());
                for (int i = 0; i < jsonArray.size(); i++) {

                    String houseid = jsonArray.getJSONObject(i).getString("housesid");
                    houseidSet.add(houseid);
                }

            }
        })).sheet().doRead();

        System.out.println(houseidSet);
    }


}
