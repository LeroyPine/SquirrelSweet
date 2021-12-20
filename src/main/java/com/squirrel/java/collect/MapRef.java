package com.squirrel.java.collect;

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
 * @date Created in 2021年05月18日 10:08
 * @since 1.0
 */
public class MapRef {


    public static void main(String[] args) {
            


        HashMap<String,String> a = new HashMap<>(4);;
        a.put("as","as");
        a.put("as1","as");
        a.put("as2","as");

        a.put("as4","as");

        String as4 = a.put("as4", "1");
        System.out.println(as4);

        String put = a.put(null, "1");
        String s = a.get(null);
        System.out.println(s);

        ConcurrentHashMap hashMap = new ConcurrentHashMap<>();;
        hashMap.put("1","12");
        Object put1 = hashMap.put("1", "124");
        System.out.println(put1);

    }


}
