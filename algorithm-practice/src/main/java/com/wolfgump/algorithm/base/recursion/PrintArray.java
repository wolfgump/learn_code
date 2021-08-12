package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 **/
public class PrintArray {
    public static void recursePrintArray(String[] array, int length) {
        if (length == 1) {
            System.out.println(array[0]);
            return;
        }
        recursePrintArray(array, length - 1);
        System.out.println(array[length - 1]);
    }

    public static void main(String[] args) {
        String[] array={"h","e","l","l","o"};
        recursePrintArray(array,array.length);
    }
}
