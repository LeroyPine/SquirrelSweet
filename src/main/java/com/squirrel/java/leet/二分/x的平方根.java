package com.squirrel.java.leet.二分;

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
 * @date Created in 2021年10月19日 14:31
 * @since 1.0
 */
public class x的平方根 {


    /**
     * 思路:
     * 1.采用二分的方式
     * 2.不过就是改用乘法而已
     *
     * @param x 结果x
     * @return 答案 y的平方等于x
     */
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
