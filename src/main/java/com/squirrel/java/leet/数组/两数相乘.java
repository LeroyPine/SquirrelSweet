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
 * @date Created in 2021年09月28日 11:14
 * @since 1.0
 */
public class 两数相乘 {

    // 两数相乘
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArray = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            final int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArray[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            ansArray[i - 1] += ansArray[i] / 10;
            ansArray[i] %= 10;
        }

        int index = ansArray[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(ansArray[index]);
            index++;
        }
        return ans.toString();

    }
}
