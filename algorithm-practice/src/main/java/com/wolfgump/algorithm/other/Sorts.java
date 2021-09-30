package com.wolfgump.algorithm.other;

import com.wolfgump.algorithm.PrintUtil;

/**
 * @author ShiTao.Gan
 **/
public class Sorts {
    public void bubble(int[] nums) {
        boolean swap = true;
        for (int i = 0; i < nums.length; i++) {
            if (!swap) {
                break;
            }
            swap = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap = true;
                }
            }
        }
    }

    //每次将为排序的数据插入前面已排序好的队列
    public void insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j + 1] >= nums[j]) {
                    break;
                } else {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minValue = nums[i];
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void quick(int[] nums) {
        quickHelp(nums, 0, nums.length - 1);
    }

    private void quickHelp(int[] nums, int low, int high) {
        int p = quickPartition(nums, nums[high]);
        quickHelp(nums, low, p - 1);
        quickHelp(nums, p + 1, high);
    }

    private int quickPartition(int[] nums, int pValue) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] <= pValue) {
                i++;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
        }
        nums[i] = pValue;
        return i;
    }
    public void  merge(int[] nums){
        mergeHelp(nums,0,nums.length-1);
    }
    private void mergeHelp(int[] nums,int low,int high){
        if(low>high){
            return;
        }
        int middle=low+(high-low)/2;
        mergeHelp(nums,low,middle-1);
        mergeHelp(nums,middle+1,high);
        doMerge(nums,low,middle,high);
    }
    private void doMerge(int[] nums,int low,int middle,int high){
        int[] numsLeft=new int[middle-low+2];
        int[] numsRight=new int[high-middle+1];
        for(int i=0;i<middle-low+1;i++){
            numsLeft[i]=nums[low+i];
        }
        numsLeft[numsLeft.length-1]=Integer.MAX_VALUE;
        for(int i=0;i<high-middle;i++){
            numsRight[i]=nums[middle+i+1];
        }
        numsRight[numsRight.length-1]=Integer.MAX_VALUE;
        int left=0,right=0;
        for(int i=low;i<=high;i++){
            if(numsLeft[left]<numsRight[right]){
                nums[i]=numsLeft[left];
                left++;
            }
            else {
                nums[i]=numsRight[right];
                right++;
            }
        }
    }


    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        int[] nums = {3, 1, 4, 2, 5};
        sorts.bubble(nums);
        System.out.println("bubble:");
        PrintUtil.printIntArray(nums);

        int[] nums1 = {3, 1, 4, 2, 5};
        sorts.insert(nums1);
        System.out.println("insert:");
        PrintUtil.printIntArray(nums1);

        int[] nums2 = {3, 1, 4, 2, 5};
        sorts.insert(nums2);
        System.out.println("select:");
        PrintUtil.printIntArray(nums2);

        int[] nums3 = {3, 1, 4, 2, 5};
        sorts.insert(nums3);
        System.out.println("quick:");
        PrintUtil.printIntArray(nums3);

        int[] nums4 = {3, 1, 4, 2, 5};
        sorts.insert(nums4);
        System.out.println("merge:");
        PrintUtil.printIntArray(nums4);
    }
}
