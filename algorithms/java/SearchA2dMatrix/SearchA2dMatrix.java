// Source : https://leetcode.com/problems/search-a-2d-matrix/
// Author : cornprincess
// Date   : 2021-03-30

/***************************************************************************************************** 
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
 * following properties:
 *
 * 	Integers in each row are sorted from left to right.
 * 	The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Constraints:
 *
 * 	m == matrix.length
 * 	n == matrix[i].length
 * 	1 <= m, n <= 100
 * 	-104 <= matrix[i][j], target <= 104
 ******************************************************************************************************/

package SearchA2dMatrix;

public class SearchA2dMatrix {
    // brute force
    // 时间复杂度：O(N * M)
    // 空间复杂度：O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // trick
    // 时间复杂度：O(N + M)
    // 空间复杂度：O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        while (row < rows && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    // binary search
    // 时间复杂度：O(logN + logM)
    // 空间复杂度：O(1)
    public boolean searchMatrix3(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        // 第一次二分，找到所在行
        // 1 3 4 17 18
        // left   right  mid  value  target
        //   0      4     2     4      9
        //   3      4     3     7      9
        //   4      4     4     8      9
        //   5      4     break

        // left   right  mid  value  target
        //   0      4     2     4      6
        //   3      4     3     17     6
        //   3      2     break
        int left = 0;
        int right = rows - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (matrix[mid][0] < target) {
                left = mid + 1;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        if (matrix[mid][0] > target) {
            mid--;
        }
        // 第二次二分，找到所在列
        left = 0;
        right = cols - 1;
        int row = mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // binary search
    // 时间复杂度：O(logN*M)
    // 空间复杂度：O(1)
    // 1  3  5  7
    // 10 11 16 20
    // 23 30 34 60
    public boolean searchMatrix4(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        int left = 1;
        int right = rows * cols;
        int mid;
        int row;
        int col;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mid % cols == 0) {
                row = mid / cols - 1;
                col = cols - 1;
            } else {
                row = mid / cols;
                col = mid % cols - 1;
            }
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix5(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        int left = 0;
        int right = rows * cols - 1;
        int mid;
        int row;
        int col;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            row = mid / cols;
            col = mid % cols;
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

