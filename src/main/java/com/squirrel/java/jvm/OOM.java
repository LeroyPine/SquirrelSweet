package com.squirrel.java.jvm;

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
 * @date Created in 2021年07月01日 10:41
 * @since 1.0
 */
public class OOM {


    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();

        while (true) {
            list.add("3252320"); // 每次增加一个1M大小的数组对象

        }

    }


}
