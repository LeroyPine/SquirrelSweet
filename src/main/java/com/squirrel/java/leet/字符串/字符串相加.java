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
     * 思路:
     * 1.从字符串的最后一位进行相加,考虑进位问题
     * 2.最后在反转字符串即可。
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 结果
     */
    public String addStrings(String str1, String str2) {
        int str1Len = str1.length() - 1;
        int str2Len = str2.length() - 1;
        // 进位
        int add = 0;
        // 定义字符串
        StringBuilder ans = new StringBuilder();
        while (str1Len >= 0 || str2Len >= 0 || add > 0) {
            // 长度小于0时给默认值
            int num1 = str1Len >= 0 ? str1.charAt(str1Len) - '0' : 0;
            int num2 = str2Len >= 0 ? str2.charAt(str2Len) - '0' : 0;
            int result = num1 + num2 + add;
            // 余数-最后一位
            int val = result % 10;
            // 进位
            add = result / 10;
            ans.append(val);
            // 指针移动
            str1Len--;
            str2Len--;
        }
        return ans.reverse().toString();
    }


}
