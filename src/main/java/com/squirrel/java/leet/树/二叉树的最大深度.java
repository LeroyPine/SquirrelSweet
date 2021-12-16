package com.squirrel.java.leet.树;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 * @date Created in 2021年07月05日 16:50
 * @since 1.0
 */
public class 二叉树的最大深度 {


    /**
     * 思路:
     * 1.找号递归终止条件
     * 2.压栈、因为是最大深度,所以每条路径都要看,选取左路径和右路径的最大值
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);

    }


}
