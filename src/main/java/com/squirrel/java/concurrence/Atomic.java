package com.squirrel.java.concurrence;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

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
 * @date Created in 2021年04月13日 09:30
 * @since 1.0
 */
public class Atomic {

    AtomicReference atomicReference = new AtomicReference<>();

    AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 1);


    AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(1, false);

}
