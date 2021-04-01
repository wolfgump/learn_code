package com.wolfgump.algorithm.base.test.stack;


import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.base.stack.ValidParentheses;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/11/12
 * To change this template use File | Settings | File and Code Templates.
 */
public class ValidParenthesesTest extends AlgorithmApplicationTests {
    @Autowired
    ValidParentheses validParentheses;
    @Test
    public void testCorrect(){
       boolean result= validParentheses.isValid("()()[]{}");
        Assert.assertTrue(result);
    }
    @Test
    public void testWrong(){
        boolean result= validParentheses.isValid("(])()[]{}");
        Assert.assertFalse(result);
    }
}
