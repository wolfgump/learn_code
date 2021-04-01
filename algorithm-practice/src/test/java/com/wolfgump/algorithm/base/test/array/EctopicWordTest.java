package com.wolfgump.algorithm.base.test.array;


import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.base.array.EctopicWord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/10/28
 * To change this template use File | Settings | File and Code Templates.
 */
public class EctopicWordTest extends AlgorithmApplicationTests {
    @Autowired
    EctopicWord ectopicWord;
    @Test
    public void testOne(){
        String source="a";
        String ectopic="a";
        System.out.println("source string:"+source);
        boolean result=ectopicWord.ectopicWord(source,ectopic);
        assertTrue(result);

    }
    @Test
    public void testThree(){
        String source="car";
        String ectopic="rat";
        System.out.println("source string:"+source);
        boolean result=ectopicWord.ectopicWord(source,ectopic);
        assertFalse(result);

    }
    @Test
    public void testMore(){
        String source="anagram";
        String ectopic="nagaram";
        System.out.println("source string:"+source);
        boolean result=ectopicWord.ectopicWord(source,ectopic);
        assertTrue(result);

    }

}
