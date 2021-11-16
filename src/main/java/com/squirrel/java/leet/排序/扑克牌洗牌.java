package com.squirrel.java.leet.排序;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

public class 扑克牌洗牌 {

    private int[] array;
    private int[] original;

    Random random = new Random();

    // 洗牌功能
    public int[] shuffle() {
        // 遍历数组  在数组内 两两交换打乱其顺序
        for (int i = 0; i < array.length; i++) {
            // 交换元素的顺序
            //
            //

            swap(i, randRange(i, array.length));
        }
        return array;
    }

    private void swap(int i, int randRange) {
        int temp = array[randRange];
        array[randRange] = array[i];
        array[i] = temp;
    }

    private int randRange(int i, int length) {


        return random.nextInt(length - i) + i;
    }

}
