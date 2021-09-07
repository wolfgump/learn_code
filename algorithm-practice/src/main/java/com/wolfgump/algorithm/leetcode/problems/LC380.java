package com.wolfgump.algorithm.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ShiTao.Gan
 * O(1) 时间插入、删除和获取随机元素
 **/
public class LC380 {
    //key:val, val:array index
    Map<Integer, Integer> map;
    ArrayList<Integer> arrayList;
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public LC380() {
        map = new HashMap<>();
        arrayList = new ArrayList();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arrayList.size());
        arrayList.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //这种写法时间复杂度是O(n)
//        int index=map.get(val);
//        map.remove(val);
//        arrayList.remove(index);
        //O(1)的时间复杂度删除数组里的一个元素的办法是把待删除的元素和末尾的元素进行交换
        int lastElement = arrayList.get(arrayList.size() - 1);
        int index = map.get(val);
        arrayList.set(index, lastElement);
        map.remove(val);
        arrayList.remove(arrayList.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int r = random.nextInt(arrayList.size());
        return arrayList.get(r);
    }
}
