// Source : https://leetcode.com/problems/spiral-matrix-ii/
// Author : zhoutianbin
// Date   : 2021-03-16

/***************************************************************************************************** 
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral 
 * order.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 * 	1 <= n <= 20
 ******************************************************************************************************/
package SpiralMatrix2;

public class SpiralMatrixii {
    // 模拟旋转法，时间复杂度 O(n^2), 空间复杂度O(1)
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0;
        int column = 0;
        // core 这里的顺序不能变，顺时针的顺序：右 -- 下 -- 左 -- 上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            // core 核心代码，这里进行顺时针旋转的逻辑，最后一个判断条件很关键，用来判断在旋转时是否碰到了其他边
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    // 按层遍历
    public int[][] generateMatrix2(int n) {
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int[][] res = new int[n][n];
        int currNum = 1;
        while (top < n && left < n) {
            // 分四次画出一个环
            for (int i = left; i <= right; i++) {
                res[top][i] = currNum++;
            }
            for (int i = top + 1; i < bottom; i++) {
                res[i][right] = currNum++;
            }
            // core 防止重复赋值
            if (left < right) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = currNum++;
                }
            }
            for (int i = bottom - 1; i > top; i--) {
                res[i][left] = currNum++;
            }
            left++;
            top++;
            bottom--;
            right--;
        }
        return res;
    }

    // core 也是按层画的思想，不过代码更加简洁
    public int[][] generateMatrix3(int n) {
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int[][] res = new int[n][n];
        int currNum = 1;
        while (currNum <= n * n) {
            // 分四次画出一个环
            for (int i = left; i <= right; i++) {
                res[top][i] = currNum++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = currNum++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = currNum++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = currNum++;
            }
            left++;
        }
        return res;
    }
}