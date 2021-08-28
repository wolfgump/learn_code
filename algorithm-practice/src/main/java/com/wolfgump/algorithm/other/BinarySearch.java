package com.wolfgump.algorithm.other;

/**
 * @author ShiTao.Gan
 **/
public class BinarySearch {
    static int binarySearch(int[] nums, int target) {
        return helper(nums, nums.length - 1, 0, target);
    }

    static int helper(int[] nums, int high, int low, int target) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return helper(nums, mid - 1, low, target);
        } else {
            return helper(nums, high, mid + 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int result = binarySearch(nums, 5);
        System.out.println(result);
    }

}
