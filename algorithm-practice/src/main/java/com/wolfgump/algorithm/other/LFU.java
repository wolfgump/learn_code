package com.wolfgump.algorithm.other;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Latest frequently
 */
public class LFU {
    private int cap;
    private PriorityQueue<Node> nodes = new PriorityQueue<>();
    private HashMap<String, Node> map = new HashMap<>();

    public LFU(int cap) {
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
        if (nodes.size() == cap) {
            Node removeNode = nodes.poll();
            map.remove(removeNode.key);

        }
        nodes.add(node);
        map.put(key, node);

    }

    private class Node implements Comparable<Integer> {
        private String key;
        private int value;
        private int cnt;

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
