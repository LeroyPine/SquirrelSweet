package com.squirrel.java.controller;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MysqlController {

  //  private final DataSource dataSource;

/*    @RequestMapping("testMysql")
    public String testMysql() {
        try {
            //获取连接,注意要关闭,这里没有关
            Connection connection = dataSource.getConnection();
            // 从连接创建statement,注意要关闭,这里没有关
            Statement statement = connection.createStatement();
            // 用statement执行sql并获取 ResultSet
            ResultSet resultSet = statement.executeQuery("select * from t1");
            //遍历result获取结果集
            List<String> list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("text");
                list.add(id + "-" + name);
            }
            //先转成json字符串再返回
            return JSON.toJSONString(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/


}
