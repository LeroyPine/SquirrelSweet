package com.squirrel.java.spi;

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
 * @d
 * ate Created in 2021年05月21日 18:25
 * @since 1.0
 */
public class FileSearch implements Search {

    @Override
    public void search(String text) {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(text);
    }
}
