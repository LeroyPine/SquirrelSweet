package com.squirrel.java.algorithm;

import com.alibaba.fastjson.JSON;
import com.squirrel.java.entity.StepInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 常数
 *
 * @author luobaosong
 * @date 2022/11/19 22:04
 * @description
 **/
@Data
public class Constant {

    @Getter
    @Setter
    private Date now;

    public static void main(String[] args) {

        StepInfo constant = new StepInfo();
        constant.setNow(new Date());

        System.out.println(JSON.toJSON(constant));
    }
}
