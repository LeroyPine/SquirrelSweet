package com.squirrel.java.leet.树;

import java.util.ArrayList;
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
 * @date Created in 2021年07月05日 17:39
 * @since 1.0
 */
public class 二叉树的所有路径 {


    // 翻转数组
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        buildPath(root, res, "");

        return res;
    }

    private void buildPath(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }
        StringBuilder ss = new StringBuilder(s);
        ss.append(Integer.toString(root.val));
        // 如果是叶子节点那么直接拼接路径
        if (root.left == null && root.right == null) {
            res.add(ss.toString());
        } else {
            ss.append("->");
            // 继续遍历
            buildPath(root.left, res, s);
            buildPath(root.right, res, s
            );
        }

    }
}
