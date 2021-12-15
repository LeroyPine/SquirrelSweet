package com.squirrel.java.file.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadFile {

    public static void main(String[] args) {
        String fileName = "D:\\文档存储\\WXWork\\1688851729182393\\Cache\\File\\2021-12\\成都测试商圈-1213.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, ReadDemo.class, new PageReadListener<ReadDemo>(dataList -> {
            for (ReadDemo demoData : dataList) {
                String path = demoData.getPath();
                String s = path.replaceAll(",", " ");
                String[] split = s.split(";");
                String collect = String.join(",", split);
                String sql = "" + "INSERT INTO `cosmos`.`base_bizcircle_copy2` (`id`, `name`, `h_level`, `c_level`, `city_code`, `center_point`, `position_border`, `description`, `status`, `create_time`, `update_time`, `create_user_code`, `create_user_name`, `update_user_code`, `update_user_name`) VALUES (" + demoData.getId() + ", '" + demoData.getTitle() + "', 'H2', 'C1', '510100', ST_GeomFromText('POINT(114.380681164562 30.5930560458786)'), ST_GeomFromText('POLYGON(("+ collect + "))'), '', 1, '2020-12-15 11:32:46', '2020-12-15 11:32:46', 'zr', '自如', 'zr', '自如');" + "";
                //log.info("读取到一条数据{}", JSON.toJSONString(demoData));
                System.out.println(sql);
            }
        })).sheet().doRead();
    }
}
