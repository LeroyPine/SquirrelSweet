package com.squirrel.java.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link extends BaseLink {


    public String houseId;

    public Integer buss;


    public static void main(String[] args) {
        BaseLink lin = new Link("as", 2);
        lin
                .setUrl("124");

        System.out.println(JSONObject.toJSONString(lin));
    }
}
