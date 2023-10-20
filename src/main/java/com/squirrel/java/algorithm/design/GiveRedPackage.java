package com.squirrel.java.algorithm.design;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Random;
import java.util.RandomAccess;

/**
 * 发红包
 *
 * @author luobaosong
 * @date 2022/11/10 13:54
 * @description
 **/
@Slf4j
public class GiveRedPackage {

    public static double packageMoney = 100;
    public static int totalPeople = 10;


    public static double getRandomPackage() {
        if (totalPeople == 1) {
            double round = Math.round(packageMoney * 100);
            return round / 100;
        }
        Random random = new Random(System.nanoTime());
        double randomNum = random.nextDouble();
        double min = 0.01;
        double max = packageMoney / totalPeople * 2;
        double money = randomNum * max;
        money = Math.max(money, min);
        money = Math.floor(money * 100);
        money = money / 100;
        packageMoney = packageMoney - money;
        totalPeople--;
        return money;
    }

    public static void main(String[] args) {
        double total = 0;
        for (int i = 0; i < 10; i++) {
            double randomPackage = getRandomPackage();
            log.info("randomPackage:{}", randomPackage);
            total += randomPackage;
        }
        log.info("====total:{}", total);

        short a =1;

        boolean equals = Objects.equals((short)1, a);
        System.out.println(equals);


    }


}
