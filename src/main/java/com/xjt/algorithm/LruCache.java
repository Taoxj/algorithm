package com.xjt.algorithm;

import java.util.HashMap;

/**
 * 设计LRU缓存
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class LruCache {

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     *
     * 实现 LRUCache 类：
     *
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     *
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     *
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     *
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * 思路：
     *
     * 参考LinkedHashMap的结构，每次插入，都把元素放到链表的头部，查询的时候也把元素放到头部
     *
     * 然后删除的时候，就需要把前后节点的指针重新指向，插入的时候发现空间不够，只要删除尾部结点即可
     */

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LruCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        // key 已存在
        if (map.containsKey(x.key)) {
            // 把旧的数据删除；
            // 将新节点 x 插入到开头；
            cache.remove(map.get(key));
            cache.addFirst(x);
        } else {
            // 链表已经满了
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }

    }

    /**
     * 双向链表
     */
    class DoubleList {

        // 头结点和尾结点
        private Node head, tail;
        private int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

}
