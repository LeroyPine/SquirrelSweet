package com.squirrel.java.concurrence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
 * @date Created in 2021年04月11日 10:19
 * @since 1.0
 */
@Slf4j
@Component
public class Singleton {

    /**
     * 初始化对象的几个步骤：
     * <p>
     * 1、分配空间
     * 2、初始化对象
     * 3、将内存空间的地址赋值给对应的引用
     * <p>
     * 操作系统指令重排序可能将几个步骤进行替换
     * 1、分配空间
     * 2、将内存空间的地址赋值给对应的引用  （此时为空对象）
     * 3、初始化对象
     */

    private volatile static Singleton singleton;

    private Singleton() {
        log.info("【私有构造方法-Singleton init】");
    }

    /**
     * 获取实例
     *
     * @return re
     */
    public static Singleton getInstance() {
        // 如果存在 那么返回
        if (singleton == null) {
            // 同步创建单例
            synchronized (Singleton.class) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }


    static {
        Singleton instance = Singleton.getInstance();
        log.info("instance:{}", instance);
    }

}
