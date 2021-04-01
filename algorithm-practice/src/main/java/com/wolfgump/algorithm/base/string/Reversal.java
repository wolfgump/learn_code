package com.wolfgump.algorithm.base.string;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/10/28
 * To change this template use File | Settings | File and Code Templates.
 */
@Component
public class Reversal {
    public String reversalString(String source) {
        if (source == null || source.length() <= 1) {
            return source;
        }
        char[] array = source.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            char tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return String.valueOf(array);
    }
}
