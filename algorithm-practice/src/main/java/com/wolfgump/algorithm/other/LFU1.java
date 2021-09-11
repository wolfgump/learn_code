package com.wolfgump.algorithm.other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Latest frequently
 * 区别：不使用PriorityQueue，自己实现一个双向列表代替其功能
 */
public class LFU1 {
    private int cap;
    private Node head;
    //尾部存放最近最少使用的 优先删除
    private Node tail;
    private HashMap<String, Node> map = new HashMap<>();

    public LFU1(int cap) {
        this.cap = cap;
    }

    public int get(String key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key).value;
    }

    public void put(String key, int val) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.setCnt(node.cnt + 1);
        } else {
            node = new Node(key, val, 1);
        }
        //判断是否超出容量
        if (map.size() == cap) {
            //删除值最小的节点，插入新节点
            Node tmp=tail;
            tail=node;
            node.pre=tmp.pre;
            node.next=null;
            map.remove(key);
        }
        else {
            //比较node节点cnt的大小，移动到合适的地方
            Node tmp=head;
            while (tmp.cnt>val){
                tmp=tmp.next;
            }
            node.next=tmp;
            node.pre=tmp.pre;
            tmp.pre=node;
        }
        map.put(key, node);

    }

    private class Node implements Comparable<Integer> {
        private String key;
        private int value;
        private int cnt;
        private Node pre;
        private Node next;

        public Node(String key, int value, int cnt) {
            this.key = key;
            this.value = value;
            this.cnt = cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Integer o) {
            return o - cnt;
        }
    }
}
