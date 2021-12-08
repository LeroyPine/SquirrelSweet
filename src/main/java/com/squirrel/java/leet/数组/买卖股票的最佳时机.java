package com.squirrel.java.leet.数组;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月22日 10:48
 * @since 1.0
 */
public class 买卖股票的最佳时机 {

    /**
     * 思路:
     * 1. 标记并比较最低值()
     * 2. 如果后一天的值比前一天的值小,那么不进行计算
     * 3. 如果当前值 - 股票最低值,那么更新利润
     *
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // 依次遍历股价
        for (int i = 0; i < prices.length; i++) {
            // 比较获得最低售价
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else if (prices[i] - lowestPrice > maxProfit) {
                maxProfit = prices[i] - lowestPrice;
            }
        }
        return maxProfit;
    }

}
