package com.wolfgump.algorithm.base.test.string;


import com.wolfgump.algorithm.AlgorithmApplicationTests;

import com.wolfgump.algorithm.base.string.Reversal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/10/28
 * To change this template use File | Settings | File and Code Templates.
 */
public class ReversalTest extends AlgorithmApplicationTests {
    @Autowired
    Reversal reversal;
    @Test
    public void testOne(){
        String source="a";
        System.out.println("source string:"+source);
        String result=reversal.reversalString(source);
        System.out.println("result string:"+result);
        assertEquals("a",result);

    }
    @Test
    public void testTwo(){
        String source="ab";
        System.out.println("source string:"+source);
        String result=reversal.reversalString(source);
        System.out.println("result string:"+result);
        assertEquals("ba",result);
    }
    @Test
    public void testTree(){
        String source="abc";
        System.out.println("source string:"+source);
        String result=reversal.reversalString(source);
        System.out.println("result string:"+result);
        assertEquals("cba",result);

    }

}
