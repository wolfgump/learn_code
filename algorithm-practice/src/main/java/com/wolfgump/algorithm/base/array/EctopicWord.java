package com.wolfgump.algorithm.base.array;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/10/28
 * To change this template use File | Settings | File and Code Templates.
 */
@Component
public class EctopicWord {
    public boolean ectopicWord(String source, String ectopic) {
        char start='a';
        int[] count = new int[26];
        char[] array = source.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i]-start;
            int countValue = count[index] + 1;
            count[index] = countValue;
        }
        char[] arrayE = ectopic.toCharArray();
        for (int i = 0; i < arrayE.length; i++) {
            int index = arrayE[i]-start;
            int countValue = count[index] - 1;
            count[index] = countValue;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
