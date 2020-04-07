// Source : https://leetcode-cn.com/problems/rotate-matrix-lcci/
// Author : cornprincess
// Date   : 2020-04-07

/***************************************************************************************************** 
 *
 * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * Given matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * Rotate the matrix in place. It becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 ******************************************************************************************************/

package CodeInterview.RotateMatrixLcci;

public class RotateMatrixLcci {
    // use extra array
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tMatrix[j][n - 1 -i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tMatrix[i][j];
            }
        }
    }

    // inline method
    public void rotateInline(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i -1][j];
                matrix[n - i -1][j] = temp;
            }
        }
        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
