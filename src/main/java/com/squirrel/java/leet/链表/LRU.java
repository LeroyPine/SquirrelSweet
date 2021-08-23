package com.squirrel.java.leet.链表;

import java.util.LinkedHashMap;
import java.util.Map;

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
 * @date Created in 2021年07月08日 21:54
 * @since 1.0
 */
public class LRU {

    // 容量
    int capacity;
    Map<Integer, Integer> map;

    public LRU(int cap) {
        this.capacity = cap;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        if (map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
