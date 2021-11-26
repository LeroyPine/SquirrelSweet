package com.squirrel.java.leet.链表.meet;

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


    // 定义双端链表

    class DLinked {
        DLinked prev;
        DLinked next;
        int key;
        int val;

        DLinked() {

        }

        DLinked(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    DLinked head;
    DLinked tail;
    int cap;
    int size;
    Map<Integer, DLinked> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        head = new DLinked();
        tail = new DLinked();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            // 移动到头结点
            moveToHead(map.get(key));
        }
        return map.get(key).val;
    }

    // 当前节点移动到头结点
    private void moveToHead(DLinked node) {

        removeNode(node);
        addToHead(node);

    }

    // 删除当前节点
    private void removeNode(DLinked node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }


    private void addToHead(DLinked node) {
        // 切断当前节点
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    public void put(int key, int value) {

        DLinked node = map.get(key);
        if (node == null) {
            // 创建一个新的节点
            DLinked dLinked = new DLinked(key, value);
            map.put(key, dLinked);
            size++;
            addToHead(dLinked);
            if (size > cap) {
                DLinked removeNode = removeTail();
                map.remove(removeNode.key);
                --size;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }

    }

    private DLinked removeTail() {
        DLinked prev = tail.prev;
        removeNode(prev);
        return prev;
    }


}
