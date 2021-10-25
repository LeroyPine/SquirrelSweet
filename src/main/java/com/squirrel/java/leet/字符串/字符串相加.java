package com.squirrel.java.leet.字符串;

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
 * @date Created in 2021年09月24日 15:23
 * @since 1.0
 */
public class 字符串相加 {

    /**
     * mind:     2 2
     * 1 2 3
     * 让其长度保持一致,从右面相加
     * 注意进位逻辑
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        // 跳出条件是什么0
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder str = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int x2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int lastN = (x1 + x2 + add) % 10;
            str.append(lastN);
            add = (x1 + x2) / 10;
            i--;
            j--;

        }
        return str.reverse().toString();
    }


    // 字符串相加
    public String addStringsV1(String num1, String num2) {

        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        int add = 0;
        StringBuilder str = new StringBuilder();
        while (num1Len >= 0 || num2Len >= 0 || add > 0) {

            // x1 x2
            int x1 = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int x2 = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
            // 相加
            int lastNum = (x1 + x2 + add) % 10;
            add = (x1 + x2 + add) / 10;
            str.append(lastNum);
            num1Len--;
            num2Len--;
        }
        return str.reverse().toString();

    }
}
