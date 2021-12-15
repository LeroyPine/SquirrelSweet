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
public class 字符串相乘 {

    /**
     * 思路:
     * 1. 依次相乘,
     * 2. 并将每次乘完后的结果进行相加
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 返回相乘后的字符串
     */
    public String multiply(String num1, String num2) {
        // 判断如果其中有一个为0,那么返回0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        // 数组1/2的长度
        int m = num1.length();
        int n = num2.length();

        // 字符串1的长度
        for (int i = n - 1; i >= 0; i--) {
            // 定义当前变量值
            StringBuilder curr = new StringBuilder();
            int add = 0;
            // 乘高位的数字要补0
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            // 然后进行相乘
            int y = num2.charAt(i) - '0';
            // 遍历字符串1
            for (int k = m - 1; k >= 0; k--) {
                int x = num1.charAt(k) - '0';
                // 结果
                int result = x * y + add;
                curr.append(result % 10);
                add = result / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStr(ans, curr.reverse().toString());
        }

        return ans;
    }

    public String addStr(String num1, String num2) {
        //  1 2 8 // 4 5
        //  0 4 5
        int oneLen = num1.length();
        int twoLen = num2.length();
        int add = 0;
        StringBuilder str = new StringBuilder();

        while (oneLen > 0 || twoLen > 0 || add != 0) {
            // 取出每次准备相加的数据
            int one = oneLen > 0 ? num1.charAt(oneLen - 1) - '0' : 0;
            int two = twoLen > 0 ? num2.charAt(twoLen - 1) - '0' : 0;

            int result = one + two + add;
            int fillNum = result % 10;
            add = result / 10;
            str.append(fillNum);
            oneLen--;
            twoLen--;
        }

        return str.reverse().toString();

    }


    public static void main(String[] args) {
        字符串相乘 a = new 字符串相乘();
        String multiply = a.multiply("110", "70");
        System.out.println(multiply);
    }
}
