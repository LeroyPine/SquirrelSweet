package com.squirrel.java.exceptio;

import org.springframework.beans.factory.config.BeanDefinition;

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


    public void testCheck() {

        Integer.parseInt("1");
        try {
            throw new CheckException("as");
        } catch (CheckException e) {
            e.printStackTrace();
        }

    }


    public void testUncheck() {

        throw new UnCheckException();
    }
}
