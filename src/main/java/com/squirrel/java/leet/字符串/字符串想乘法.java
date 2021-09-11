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
 * @date Created in 2021年09月11日 11:25
 * @since 1.0
 */
public class 字符串想乘法 {

    public String multiply(String num1, String num2) {
        // 如果都为0 那么直接返回0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 定义答案变量
        String ans = "0";
        int m = num1.length();
        int n = num2.length();
        //
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            //
            for (int j = m - 1; j >= 0; j--) {
                // 进行相乘
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            // 进行字符串相加操作
            ans = addStr(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStr(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        // ~
        StringBuilder ans = new StringBuilder();
        //
        while (i >= 0 || j >= 0 || add != 0) {
            int iNum = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jNum = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = iNum + jNum + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}
