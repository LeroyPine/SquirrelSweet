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
public class 平方根 {


    public static int mySqrt(int x) {

        int l = 0;
        int r = x;

        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if ((double) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        int i = mySqrt(10);
        System.out.println(i);
    }

}
