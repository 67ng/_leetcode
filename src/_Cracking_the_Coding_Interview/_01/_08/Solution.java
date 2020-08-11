package _Cracking_the_Coding_Interview._01._08;

/**
 * @Description: 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零
 * @Author: caffebaby
 * @Date: 2020/7/31
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowHaveZero = false;
        boolean isFirstColHaveZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColHaveZero = true;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowHaveZero = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (isFirstColHaveZero) {
                matrix[i][0] = 0;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (isFirstRowHaveZero) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
