package com.squirrel.java.leet.递归;

public class 小青蛙跳台阶 {


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * <p>
     * <p>
     * 到达n级台阶的时候可能前一步是  n-1  也可能是  n-2   总共有多少种跳法
     * <p>
     * f(n) = f(n-1) + f(n-2)
     *f1 = 1 f2= 2  f3 = 3   f4 = 5
     * 3台阶时候： 111  12  21   f1 + f2   3
     * 4台阶时候： 1111 112 121 211 22    5    f3 + f2
     *
     */

    public int qwt(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return qwt(n - 1) + qwt(n - 2);
    }

}
