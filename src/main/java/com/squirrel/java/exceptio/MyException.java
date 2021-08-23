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
 * @date Created in 2021年05月13日 16:41
 * @since 1.0
 */
public class MyException extends RuntimeException{
    private Integer code;
    private String message;

    public MyException(String message) {
        super(message);
        this.code = 400100;
        this.message = message;
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
