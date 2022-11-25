package com.squirrel.java.algorithm.bfs;

import java.util.*;

/**
 * @author luobaosong
 * @date 2022/11/21 18:19
 * @description
 **/
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        //记录死局
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        //记录走过的路
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // 从起点开始进行BFS
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                // 上下拨动密码
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }


    public String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
