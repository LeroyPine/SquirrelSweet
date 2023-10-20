package com.squirrel.java.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author luobaosong
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StepInfo {

    private String userName;
    private Long stepCount;


    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date now;
}
