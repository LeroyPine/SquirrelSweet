package com.squirrel.java.leet.随机;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Find5N {


    public static void main(String[] args) {
        Random random = new Random();
        int bound = 5;
        Set<Integer> set = new HashSet<>();
        while (bound > 0) {
            int randomNum = random.nextInt(5);
            if (!set.contains(randomNum)) {
                set.add(randomNum);
                bound--;
                System.out.println(randomNum);
            }

        }
    }


}
