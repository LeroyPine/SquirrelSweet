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
public class Lru {


    // 使用双端队列

    class DLinked {
        private DLinked prev;
        private DLinked next;
        private int key;
        private int val;

        public DLinked() {
        }

        public DLinked(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 头尾节点
    private DLinked head;
    private DLinked tail;
    // 容量
    private int cap;
    private int size;
    // O1 获取元素
    private Map<Integer, DLinked> map = new HashMap<>();

    public Lru(int cap) {
        this.size = 0;
        this.cap = cap;
        head = new DLinked();
        tail = new DLinked();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 将该节点加入到头结点
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToHead(map.get(key));
        //

        return map.get(key).val;
    }


    public void put(int key, int val) {
        final DLinked dLinked = map.get(key);
        // 首先判断其是否存在

        if (dLinked == null){
            // 创建一个新的节点
            final DLinked dLinked1 = new DLinked(key, val);
            //判断是否到了最大容量
            if (size == cap){
                //  移除为节点
                removeTail();
                // 添加头结点
                moveToHead(dLinked1);
            }else {
                addHead(dLinked1);
                size++;
            }
        }else {
            // 直接更新该节点
            dLinked.val = val;
            moveToHead(dLinked);
        }
    }


    // 节点移动到头结点
    public void moveToHead(DLinked node) {
        //

        removeTail();
        addHead(node);

    }

    public void addHead(DLinked node) {
        node.prev = head;
        node.next = head.next;
        // 注意顺序
        head.next.prev = node;
        head.next = node;
    }

    //

    public void removeTail() {
        final DLinked prev = tail.prev;
        // 移除prev
        move(prev);
    }

    public void move(DLinked node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
