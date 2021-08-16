package com.wolfgump.algorithm.base.test.tree;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.base.tree.Tree;
import com.wolfgump.algorithm.base.tree.TreePrint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ganshitao
 * @date: 2019/11/26
 */
public class TreeSearchTest extends AlgorithmApplicationTests {

    @Autowired
    TreePrint treePrint;


    public Tree init() {
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree2 = new Tree(2, tree4, tree5);
        Tree tree3 = new Tree(3);
        Tree tree = new Tree(1, tree2, tree3);
        return tree;

    }

    @Test
    public void testPreSearch() {
        Tree tree = init();
        treePrint.printPre(tree);
    }
    @Test
    public void testInSearch() {
        Tree tree = init();
        treePrint.printIn(tree);
    }
    @Test
    public void testPostSearch() {
        Tree tree = init();
        treePrint.printPost(tree);
    }
}
