package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 **/
public class MathPower {
    public static Integer power(Integer a,Integer b){
        if(b<=0){
            return 1;
        }
        return a*power(a,b-1);
    }

    public static void main(String[] args) {
        Integer result=power(2,9);
        System.out.println(result);
    }
}
