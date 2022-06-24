package com.squirrel.java.leet.树.meet;

public class 判断一数组是否为二叉树的后序遍历 {

    public static boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1)
            return false;
        return judge(sequence, 0, sequence.length - 1);
    }


    //   8
    //2     10
//  1   4  9   11
    private static boolean judge(int[] sequence, int left, int right) {
        //  序列
        // 首先拿到二叉树的根节点
        // 如果左节点大于右节点  那么 直接返回
        if (left > right) {
            return false;
        }
        // 根节点 为后续 遍历的第倒数一个节点
        int root = sequence[right];
        // 第一个比根节点大的下标
        int index = right;
        //
        for (int i = left; i <= right - 1; i++) {
            //
            if (sequence[i] > root) {
                index = i;
                i++;

                while (i <= right - 1) {
                    if (sequence[i] < root) {
                        return false;
                    }
                    i++;
                }
            }
        }
        return judge(sequence, left, index - 1) && judge(sequence, index, right - 1);


    }
}
