package com.squirrel.java.exceptio;

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
 * @date Created in 2021年05月13日 16:42
 * @since 1.0
 */
public class TestExce {

    public static void main(String[] args) {

        try {
            if (1 == 1) {
                throw new MyException("as");
            }
        } catch (Exception e) {
            if (e instanceof MyException) {
                System.out.println(123);
            } else {
                System.out.println(12421421);
            }
        }

    }
}
