// Source : https://leetcode.com/problems/surface-area-of-3d-shapes/
// Author : cornprincess
// Date   : 2020-03-25

/***************************************************************************************************** 
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
 * 
 * Example 1:
 * 
 * Input: [[2]]
 * Output: 10
 * 
 * Example 2:
 * 
 * Input: [[1,2],[3,4]]
 * Output: 34
 * 
 * Example 3:
 * 
 * Input: [[1,0],[0,2]]
 * Output: 16
 * 
 * Example 4:
 * 
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * 
 * Example 5:
 * 
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * 
 * Note:
 * 
 * 	1 <= N <= 50
 * 	0 <= grid[i][j] <= 50
 * 
 ******************************************************************************************************/

package SurfaceAreaOf3dShapes;

public class SurfaceAreaOf3dShapes {
    public int surfaceArea(int[][] grid) {
        int[] nr = {0, -1, 0, 1};
        int[] nc = {-1, 0, 1, 0};

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; k++) {
                        int nv = 0;
                        if (0 <= i + nr[k] && i + nr[k] < grid.length &&  0 <= j + nc[k] && j + nc[k] < grid.length) {
                            nv = grid[i + nr[k]][j + nc[k]];
                        }
                        ans += Math.max(v - nv, 0);
                    }
                }
            }
        }
        return ans;
    }
}
