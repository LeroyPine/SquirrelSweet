package com.squirrel.java.leet.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
 * @date Created in 2021年09月27日 10:18
 * @since 1.0
 */
public class 合并区间 {

    /**
     * 思路:
     * <p>
     * 1.首先按照左侧数据进行排序
     * 2.然后判断元素的左区间和右区间大小
     * 3.如果前一个数的右区间小于下一个元素的左区间,那么直接将下一个元素加入到结果集中
     * 4.如果前一个数的右区间大于等于下一个元素的左区间,就将其合并,合并的右区间元素进行相比较,选大的。
     *
     * @param intervals 区间
     * @return 合并后的数组
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][2];
        }
        // 首先将数组按照左端数字进行升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // 找出左右区间的数字
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < L) {
                result.add(new int[]{L, R});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], R);
            }
        }
        return result.toArray(new int[result.size()][]);

    }
}
