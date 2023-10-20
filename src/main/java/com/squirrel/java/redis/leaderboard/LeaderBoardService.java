package com.squirrel.java.redis.leaderboard;

import com.alibaba.fastjson.JSONObject;
import com.squirrel.java.entity.StepInfo;
import com.squirrel.java.proxy.Squirrel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class LeaderBoardService {

    @Autowired
    private RedisTemplate redisTemplate;

    public List<StepInfo> getLeaderBoard() {

        Set leaderBoard = redisTemplate.opsForZSet().rangeByScore("leaderBoard", 1, 10);

        log.info("lea:{}", JSONObject.toJSON(leaderBoard));

        return Collections.emptyList();
    }


    public void  Sas(String ... as){

    }



    public static void main(String[] args) {
        Squirrel sa = new Squirrel();
        Integer a = sa.getA();
        System.out.println(a==1);
    }

    public void addDataForLeaderBoard(String userId) {
        // 获取ZSet
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.addIfAbsent("leaderBoard", userId, 10);
    }

    public void updateDataForLeaderBoard(String userId, Long count) {
        // 获取ZSet
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.incrementScore("leaderBoard", userId, count);
    }

}
