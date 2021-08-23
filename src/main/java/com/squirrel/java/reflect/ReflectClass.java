package com.squirrel.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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
 * @date Created in 2021年05月21日 11:29
 * @since 1.0
 */
public class ReflectClass {

    public ReflectClass() {
    }

    public ReflectClass(String s) {
        System.out.printf("");
    }


    public void skr(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {


        Class<? extends ReflectClass> aClass = this.getClass();

        String name = aClass.getName();
        System.out.println("name:" + name);
        System.out.println("simpleName:" + aClass.getSimpleName());
        System.out.println("全限定类名" + aClass.getCanonicalName());

        ReflectClass reflectClass = aClass.newInstance();

        Constructor<?>[] constructors = aClass.getConstructors();

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            //method.invoke()
        }

        //aClass.getDeclaredFields()

        Object as = Class.forName("as").newInstance();
        Class<? extends ReflectClass> aClass1 = this.getClass();

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ReflectClass reflectClass = new ReflectClass();

        // reflectClass.skr(null);
        // Class.forName()


    }
}
