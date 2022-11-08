package com.squirrel.java.leet.listnode.meet;

import lombok.Data;

import java.util.HashMap;
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
 * @date Created in 2021年09月16日 10:50
 * @since 1.0
 */
@Data
public class LRUCache {

    // put
    // get
    // 移除最近最久未使用的元素  使用双向链表实现。

    class DLinked {

        int key;
        int value;  //节点值
        DLinked prev; //上一个节点
        DLinked next; // 下一个节点

        DLinked() {

        }

        // 构造
        DLinked(int key, int value) {
            this.key = key;
            this.value = value;

        }
    }

    int size; // 集合大小
    int cap; // 容量
    DLinked head;
    DLinked tail;

    LRUCache(int cap) {
        this.head = new DLinked();
        this.tail = new DLinked();
        head.next = tail;
        tail.prev = head;
        size = 0;
        this.cap = cap;

    }

    // 用作缓存
    Map<Integer, DLinked> cache = new HashMap<>();


    public int get(int key) {

        DLinked dLinked = cache.get(key);
        // 判断是否存在
        if (dLinked == null) {
            return -1;
        } else {
            removeNode(dLinked);
            moveToHead(dLinked);
            return dLinked.value;
        }
    }

    private void removeNode(DLinked dLinked) {
        //
        dLinked.next.prev = dLinked.prev;
        dLinked.prev.next = dLinked.next;
    }

    private void moveToHead(DLinked dLinked) {
        //
        dLinked.next = head.next;
        dLinked.prev = head;
        head.next.prev = dLinked;
        head.next = dLinked;

    }

    public void put(int key, int value) {
        // 校验是否存在key,如果存在替换 并移动到头结点，  如果不存在 添加 移动到头结点
        DLinked dLinked = cache.get(key);
        if (dLinked == null) {
            DLinked newNode = new DLinked(key, value);
            size++;
            cache.put(key, newNode);
            moveToHead(newNode);
            if (size > cap) {
                DLinked tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            dLinked.value = value;
            removeNode(dLinked);
            moveToHead(dLinked);
        }

    }

    private DLinked removeTail() {
        DLinked prev = tail.prev;
        removeNode(prev);
        return prev;
    }


}
