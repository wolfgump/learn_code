package com.wolfgump.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShiTao.Gan
 * n皇后
 **/
public class Nqueue {
    static List<String[][]> res = new ArrayList<>();

    public static List<String[][]> nq(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ".");
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * @param board board[row]  路径   下一个路径是下一行
     * @param row   选择列表   每次选择放在哪一列上
     *
     */
    static void backtrack(String[][] board, int row) {
        //结束条件
        if (row == board.length) {
            String[][] okBoard = new String[board.length][board.length];
            for (int i = 0; i < board.length; i++) {
                okBoard[i] = Arrays.copyOf(board[i], board[i].length);
            }
            res.add(okBoard);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            //排出非法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            //选择
            board[row][col] = "Q";
            backtrack(board, row + 1);
            //取消选择
            board[row][col] = ".";
        }
    }

    static boolean isValid(String[][] board, int row, int col) {
        int leftUp = col - 1;
        int rightUp = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col].equals("Q")) {
                return false;
            }
            if (leftUp >= 0 && board[i][leftUp].equals("Q")) {
                return false;
            }
            if (rightUp < 8 && board[i][rightUp].equals("Q")) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String[][]> result = nq(8);
    }

}
