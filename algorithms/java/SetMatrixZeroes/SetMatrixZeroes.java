// Source : https://leetcode.com/problems/set-matrix-zeroes/
// Author : cornprincess
// Date   : 2021-03-21

/***************************************************************************************************** 
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * 
 * Follow up:
 * 
 * 	A straight forward solution using O(mn) space is probably a bad idea.
 * 	A simple improvement uses O(m + n) space, but still not the best solution.
 * 	Could you devise a constant space solution?
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Example 2:
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * Constraints:
 * 
 * 	m == matrix.length
 * 	n == matrix[0].length
 * 	1 <= m, n <= 200
 * 	-231 <= matrix[i][j] <= 231 - 1
 ******************************************************************************************************/

package SetMatrixZeroes;

import java.util.Arrays;

public class SetMatrixZeroes {
    // 最简单的方法，使用两个数组分别记录为0的所在行以及所在列
    // 记录完毕之后遍历数组，对其进行置0
    // 时间复杂度： O(m*n)
    // 空间复杂度：O(m+n)
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 由于题目要求使用原地的方法，因此要使用改进版
    // core 改进方法：使用第一行和第一列来替代上述方法中的两个数组
    public void setZeroes2(int[][] matrix) {
        boolean flagRow = false;
        boolean flagCol = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagCol = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                flagRow = true;
                break;
            }
        }

        // 标记
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 置零
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (flagRow) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
