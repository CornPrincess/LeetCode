// Source : https://leetcode.com/problems/available-captures-for-rook/
// Author : cornprincess
// Date   : 2020-03-26

/***************************************************************************************************** 
 *
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, 
 * and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase 
 * characters represent white pieces, and lowercase characters represent black pieces.
 *
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, 
 * west, and south), then moves in that direction until it chooses to stop, reaches the edge of the 
 * board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks 
 * cannot move into the same square as other friendly bishops.
 *
 * Return the number of pawns the rook can capture in one move.
 *
 * Example 1:
 *
 * Input: 
 * [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p
 * "],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".",
 * "."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * In this example the rook is able to capture all the pawns.
 *
 * Example 2:
 *
 * Input: 
 * [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".",".
 * "],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".",
 * "."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation: 
 * Bishops are blocking the rook to capture any pawn.
 *
 * Example 3:
 *
 * Input: 
 * [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".",".
 * "],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".",
 * "."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * The rook can capture the pawns at positions b5, d6 and f5.
 *
 * Note:
 *
 * 	board.length == board[i].length == 8
 * 	board[i][j] is either 'R', '.', 'B', or 'p'
 * 	There is exactly one cell with board[i][j] == 'R'
 *
 ******************************************************************************************************/

package AvailableCapturesForRook;

public class AvailableCapturesForRook {
    // Time Complexity：O(n^2)
    // Space Complexity：O(1)
    public int bruteForce(char[][] board) {
        int n = board.length;
        int r = findRLocation(board)[0];
        int c = findRLocation(board)[1];

        int ans = 0;
        for (int j = c + 1; j < n; j++) {
            if (board[r][j] == 'B') {
                break;
            } else if (board[r][j] == 'p') {
                ans++;
                break;
            }
        }

        for (int j = c - 1; j > 0; j--) {
            if (board[r][j] == 'B') {
                break;
            } else if (board[r][j] == 'p') {
                ans++;
                break;
            }
        }

        for (int i = r - 1; i > 0; i--) {
            if (board[i][c] == 'B') {
                break;
            } else if (board[i][c] == 'p') {
                ans++;
                break;
            }
        }

        for (int i = r + 1; i < n; i++) {
            if (board[i][c] == 'B') {
                break;
            } else if (board[i][c] == 'p') {
                ans++;
                break;
            }
        }
        return ans;
    }

    public int bruteForce2(char[][] board) {
        int n = board.length;
        int r = findRLocation(board)[0];
        int c = findRLocation(board)[1];
        int ans = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        for (int i = 0; i < 4; i++) {
            for (int step = 1; ; step++) {
                int tx = r + step * dx[i];
                int ty = c + step * dy[i];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n || board[tx][ty] == 'B') {
                    break;
                } else if (board[tx][ty] == 'p') {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    private int[] findRLocation(char[][] board) {
        int n = board.length;
        int r = 0;
        int c = 0;
        searchLocation:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break searchLocation;
                }
            }
        }
        return new int[]{r, c};
    }
}
