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

        // 遍历num2
        for (int i = n - 1; i >= 0; i--) {
            // 记录与每一个数进行相乘后的结果
            StringBuilder temp = new StringBuilder();
            // 如果当前数不是末尾,那么进行补0相乘的时候.
            for (int j = n - 1; j > i; j--) {
                temp.append(0);
            }
            int add = 0;
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int result = x * y + add;
                temp.append(result % 10);
                add = result / 10;
            }
            if (add != 0) {
                temp.append(add % 10);
            }

            ans = addStr(ans, temp.reverse().toString());
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
        字符串想乘法 a = new 字符串想乘法();
        String multiply = a.multiply("110", "70");
        System.out.println(multiply);
    }
}
