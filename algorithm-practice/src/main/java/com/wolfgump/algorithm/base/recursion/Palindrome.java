package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 * palindrome demo:redivider, noon, civic, radar, level, rotor, kayak, reviver, racecar, redder, madam, refer...
 **/
public class Palindrome {
    public static boolean isPalindrome(String raw) {
        int begin = 0, end = raw.length() - 1;
        while (begin < end) {
            if (raw.charAt(begin) != raw.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
    public static boolean recursePalindrome(String raw,int start,int end){
        if(start>=end){
            return true;
        }
        return raw.charAt(start)==raw.charAt(end)&&recursePalindrome(raw,start+1,end-1);
    }
    public static void main(String[] args) {
        boolean result = recursePalindrome("redivider",0,"redivider".length()-1);
        System.out.println(result);
    }
}
