package com.squirrel.java;

import com.squirrel.java.entity.StepInfo;
import com.squirrel.java.redis.leaderboard.LeaderBoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
class SquirrelJavaApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LeaderBoardService leaderBoardService;

    @Test
    void contextLoads() {

        leaderBoardService.addDataForLeaderBoard("pig");
        leaderBoardService.addDataForLeaderBoard("cat");
        leaderBoardService.addDataForLeaderBoard("norse");
        leaderBoardService.addDataForLeaderBoard("fia");

        List<StepInfo> leaderBoard = leaderBoardService.getLeaderBoard();
        System.out.println(12);
    }

}
