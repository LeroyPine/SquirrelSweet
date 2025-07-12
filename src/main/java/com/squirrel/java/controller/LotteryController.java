package com.squirrel.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class LotteryController {

    @GetMapping("/lottery/draw")
    public String drawLottery(@RequestParam("participants") String participants) {
        if (participants == null || participants.trim().isEmpty()) {
            return "请提供参与者名单，如：张三,李四,王五";
        }
        List<String> names = Arrays.asList(participants.split(","));
        if (names.isEmpty()) {
            return "参与者名单不能为空";
        }
        Random random = new Random();
        String winner = names.get(random.nextInt(names.size())).trim();
        return "中奖者是：" + winner;
    }
} 