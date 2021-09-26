package com.squirrel.java.leet.链表.first;

import org.springframework.web.servlet.DispatcherServlet;

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
 * @date Created in 2021年04月29日 16:51
 * @since 1.0
 */
public class StringAdd {

    //     1  2   3   4  5
    //     4  5   7   6  3

    public static void main(String[] args) {
        String s = addString("12345", "4576");
        System.out.println(s);
    }

    public static String addString(String a, String b) {

        // 竖向相加

        int aL = a.length() - 1;
        int bL = b.length() - 1;
        int carry = 0;
        // 定义str
        StringBuilder str = new StringBuilder();

        // 长度大于0
        while (aL >= 0 || bL >= 0 || carry != 0) {

            int aNum = aL >= 0 ? a.charAt(aL) - '0' : 0;
            int bNum = bL >= 0 ? b.charAt(bL) - '0' : 0;
            int result = aNum + bNum + carry;

            int end = result % 10;
            str.append(end);

            carry = result / 10;
            aL--;
            bL--;
        }

        str.reverse();
        return str.toString();

    }

}
