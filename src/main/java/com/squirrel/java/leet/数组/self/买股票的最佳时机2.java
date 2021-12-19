package com.squirrel.java.leet.数组.self;

public class 买股票的最佳时机2 {


    /**
     * 思路:
     * 1.贪心算法,每次收集有收益的
     * 2. 最终的值即为最大利润
     *
     * @param prices 价格
     * @return 利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = Math.max(0, prices[i] - prices[i - 1]);
            ans = ans + profit;
        }
        return ans;
    }

}
