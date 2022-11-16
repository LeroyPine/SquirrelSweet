package com.squirrel.java.algorithm.dynamic;

/**
 * @author luobaosong
 * @date 2022/11/12 17:22
 * @description
 **/
public class Fib {

    /**
     * 斐波那契 递归
     *
     * @param N n
     * @return int
     */
    public int fib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }


    public int fibMemo(int N) {
        // 采用备忘录模式的斐波那契数列
        int[] memo = new int[N + 1];
        return helpFib(memo, N);
    }

    private int helpFib(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helpFib(memo, n - 1) + helpFib(memo, n - 2);
        return memo[n];
    }


    public int dpFib(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];

    }
}
