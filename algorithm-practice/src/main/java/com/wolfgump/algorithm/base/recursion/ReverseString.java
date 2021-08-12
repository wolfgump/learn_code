package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 **/
public class ReverseString {
    public static String reverseString(String s) {
        //base case
        if (s.length() < 2) {
            return s;
        }
        //recurse case
        //毫无疑问的相信我的方法可以正确处理 比当前字符串少一个字符的翻转
        //reverseString(s.substring(1)) 少一个字符的字符串翻转，我们相信他是可以正确指导结果的
        return reverseString(s.substring(1)) + s.substring(0, 1);
    }

    public static void main(String[] args) {
        String result = reverseString("Hello");
        System.out.println(result);
    }
}
