package com.squirrel.java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luobaosong
 * @date 2022/11/19 21:50
 * @description
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chain {


    /**
     * id
     */
    private Integer id;
    private Integer preId;

}
