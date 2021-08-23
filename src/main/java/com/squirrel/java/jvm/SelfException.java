package com.squirrel.java.jvm;

import java.sql.Connection;
import java.util.HashMap;
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
 * @date Created in 2021年04月20日 14:03
 * @since 1.0
 */
public class SelfException {

    public void testException() {
        try {
            int a = 0;
            if (a == 0) {
                throw new ArithmeticException("Zero");
            }
        } catch (ArithmeticException e) {

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {

        System.out.println(3 >>>16);
    }
}
