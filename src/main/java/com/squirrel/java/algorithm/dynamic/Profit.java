package com.squirrel.java.algorithm.dynamic;

/**
 * @author luobaosong
 * @date 2022/11/26 22:38
 * @description
 **/
public class Profit {

    /*
     * 动态规划主要是先找出状态转换方程
     *
     * 股票相关
     * n 天数
     * k 一天内能交易的最大次数
     * i 持有状态 ： 持有 ｜ 没有持有
     *
     */


    /**
     * 卖股票的最佳时机
     *
     * @param prices 价格
     * @return int
     */
    public int maxProfit(int[] prices) {
        // 天数
        int n = prices.length;
        // dp
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // 写出状态转移方式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }


    /**
     * 最大利润v2
     * k 正无穷 不限制次数交易
     *
     * @param prices 价格
     * @return int
     */
    public int maxProfitV2(int[] prices) {
        // 天数
        int n = prices.length;
        // dp
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // 写出状态转移方式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    /**
     * 最大利润v3
     * 冷冻期
     *
     * @param prices 价格
     * @return int
     */
    public int maxProfitV3(int[] prices) {
        // 天数
        int n = prices.length;
        // dp
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }
            // 写出状态转移方式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    /**
     * 买股票的最佳时机 含手续费
     *
     * @param prices 价格
     * @param fee    费
     * @return int
     */
    public int maxProfit(int[] prices, int fee) {
        // dp
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 找出状态转移方程
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // 未持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 已持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    public int maxProfit_k_2(int[] prices) {
        int max_k = 2, n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }

    public int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        if (max_k > n / 2) {
            // 复用之前交易次数 k 没有限制的情况
            return maxProfitV2(prices);
        }

        // base case：
        // dp[-1][...][0] = dp[...][0][0] = 0
        // dp[-1][...][1] = dp[...][0][1] = -infinity
        int[][][] dp = new int[n][max_k + 1][2];
        // k = 0 时的 base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 i = -1 时的 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }


    /**
     * 最大利润都在一个
     * 同时考虑交易次数的限制、冷冻期和手续费
     *
     * @param max_k    马克斯·k
     * @param prices   价格
     * @param cooldown 冷却时间
     * @param fee      费
     * @return int
     */
    int maxProfitAllInOne(int max_k, int[] prices, int cooldown, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (max_k > n / 2) {
            // 交易次数 k 没有限制的情况
            //return maxProfit_k_inf(prices, cooldown, fee);
            // todo
        }

        int[][][] dp = new int[n][max_k + 1][2];
        // k = 0 时的 base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // base case 1
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i] - fee;
                    continue;
                }

                // 包含 cooldown 的 base case
                if (i - cooldown - 1 < 0) {
                    // base case 2
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    // 别忘了减 fee
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], -prices[i] - fee);
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                // 同时考虑 cooldown 和 fee
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - cooldown - 1][k - 1][0] - prices[i] - fee);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
