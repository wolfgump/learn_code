package com.wolfgump.algorithm.other;

import java.util.HashMap;

/**
 * LRU Latest Recently Use
 * @author ShiTao.Gan
 **/
public class LRU {
    HashMap<Integer, ListNode> map;
    DoubleList doubleList;
    // 最大容量
    private int cap;

    public LRU(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(capacity);
        doubleList = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
        }
        if (map.size() == cap) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        ListNode node = map.get(key);
        //先删除
        doubleList.remove(node);
        //再新增
        doubleList.addLast(node);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        ListNode node = new ListNode(key, val);
        doubleList.addLast(node);
        map.put(key, node);

    }

    /* 删除某一个 key */
    private void deleteKey(int key) {
        ListNode x = map.get(key);
        map.remove(key);
        doubleList.remove(x);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        ListNode node = doubleList.removeFirst();
        map.remove(node.key);

    }

    class DoubleList {
        ListNode head, tail;
        int size;

        public DoubleList() {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        // 在链表尾部添加节点 x，时间 O(1)
        public void addLast(ListNode x) {
            ListNode pre = tail.pre;
            tail.pre = x;
            x.next = tail;
            pre.next = x;
            x.pre = pre;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(ListNode x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }

        // 删除链表中第一个节点，并返回该节点，时间 O(1)
        public ListNode removeFirst() {
            if (head == tail) {
                return null;
            }
            remove(head.next);
            return head;
        }

        // 返回链表长度，时间 O(1)
        public int size() {
            return size;
        }
    }

    class ListNode {
        private int key, val;
        private ListNode pre;
        private ListNode next;

        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}
