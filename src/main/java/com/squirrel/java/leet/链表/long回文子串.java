package com.squirrel.java.leet.链表;

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
 * @date Created in 2021年04月29日 14:53
 * @since 1.0
 */
public class long回文子串 {

    public static void main(String[] args) {
       /* String longestPalindrome(String s) {



            //边界条件判断
            if (s.length() < 2)
                return s;
            //start表示最长回文串开始的位置，
            //maxLen表示最长回文串的长度
            int start    = 0, maxLen = 0;
            int length = s.length();
            for (int i = 0; i < length; ) {
                //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
                // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
                if (length - i <= maxLen / 2)
                    break;
                int left = i, right = i;
                while (right < length - 1 && s.charAt(right + 1) == s.charAt(right))
                    ++right; //过滤掉重复的
                //下次在判断的时候从重复的下一个字符开始判断
                i = right + 1;
                //然后往两边判断，找出回文子串的长度
                while (right < length - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                    ++right;
                    --left;
                }
                //保留最长的
                if (right - left + 1 > maxLen) {
                    start = left;
                    maxLen = right - left + 1;
                }
            }
            //截取回文子串
            return s.substring(start, start + maxLen);
        }
*/

    }
}
