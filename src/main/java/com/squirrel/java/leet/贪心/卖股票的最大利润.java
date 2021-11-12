package com.squirrel.java.leet.贪心;

public class 卖股票的最大利润 {

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {

            ans += Math.max(0, prices[i] - prices[i - 1]);

        }
        return ans;
    }


    public static void main(String[] args) {
        卖股票的最大利润 s = new 卖股票的最大利润();
        int i = s.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
}
