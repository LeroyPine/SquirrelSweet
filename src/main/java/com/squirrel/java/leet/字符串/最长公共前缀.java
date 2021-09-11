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
 * @date Created in 2021年09月11日 13:34
 * @since 1.0
 */
public class 最长公共前缀 {

    /**
     * class Solution {
     *     public String longestCommonPrefix(String[] strs) {
     *         if (strs == null || strs.length == 0) {
     *             return "";
     *         }
     *         int length = strs[0].length();
     *         int count = strs.length;
     *         for (int i = 0; i < length; i++) {
     *             char c = strs[0].charAt(i);
     *             for (int j = 1; j < count; j++) {
     *                 if (i == strs[j].length() || strs[j].charAt(i) != c) {
     *                     return strs[0].substring(0, i);
     *                 }
     *             }
     *         }
     *         return strs[0];
     *     }
     * }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param strs
     * @return
     */

    // 最长公共前缀
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        // 纵向比较
        final String firstStr = strs[0];
        int count = firstStr.length();

        for (int i = 0; i < count; i++) {

            final char fChar = firstStr.charAt(i);

            for (int j = 1; j < count; j++) {

                if (strs[j].length() == i || strs[j].charAt(i) != fChar) {
                    return strs[0].substring(0, i);
                }

            }

        }


        return "";
    }
}
