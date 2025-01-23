package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int[][] adjacentCells = new int[][] {
                { 0, 1 }, // right
                { 0, -1 }, // left
                { 1, 0 }, // down
                { -1, 0 }, // up
        };

        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        // replace all the ones with -1,
        // and add all the zero positions to queue.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], column = current[1];

            for (int[] cell : adjacentCells) {
                int neighbouringRow = row + cell[0];
                int neighbouringColumn = column + cell[1];

                // if the neighbouring cell happens to be in bound and
                // has the value of -1, update the value to current cell
                // value + 1. Also add this neighbouring cell to the queue.
                if (neighbouringRow >= 0
                        && neighbouringRow != m
                        && neighbouringColumn >= 0
                        && neighbouringColumn != n
                        && mat[neighbouringRow][neighbouringColumn] == -1) {
                    mat[neighbouringRow][neighbouringColumn] = mat[row][column] + 1;
                    queue.add(new int[] { neighbouringRow, neighbouringColumn });
                }
            }
        }

        return mat;
    }
}
// @lc code=end
