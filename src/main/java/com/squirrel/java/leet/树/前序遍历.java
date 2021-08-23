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
 * @date Created in 2021年06月25日 00:25
 * @since 1.0
 */
public class 前序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {

        // 递归压栈   前序遍历: 根左右

        List<Integer> list = new ArrayList<>();

        postOrder(root, list);

        return list;


    }

    private void postOrder(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);
            postOrder(root.left, list);
            postOrder(root.right, list);
        }

    }


}
