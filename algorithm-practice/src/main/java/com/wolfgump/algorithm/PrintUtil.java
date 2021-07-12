package com.wolfgump.algorithm;

/**
 * @author ShiTao.Gan
 **/
public class PrintUtil {
    public static void printIntArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i!= nums.length-1){
                System.out.print(",");
            }
        }
        System.out.println("");
    }
}
