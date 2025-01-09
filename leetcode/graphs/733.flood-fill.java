package graphs;

/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    private void dfs(int[][] image, int row, int column, int currentColor, int newColor) {

        int adjacentCells[][] = {
                { 0, 1 }, // right
                { 0, -1 }, // left
                { 1, 0 }, // down
                { -1, 0 } // up
        };

        // determine total number of rows and columns of the matrix
        int m = image.length;
        int n = image[0].length;

        for (int[] cell : adjacentCells) {

            // calculate neighbouring cell indices
            int r = row + cell[0];
            int c = column + cell[1];

            // check if the cell is within the matrix,
            // and has the same color as the starting cell
            if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == currentColor) {
                image[r][c] = newColor;
                dfs(image, r, c, currentColor, newColor);
            }

        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // if the starting cell has the same color as the new color
        // return the image as it is
        if (image[sr][sc] == color) {
            return image;
        }

        // get the value of the starting cell,
        // and set the starting cell to have new color
        int currentColor = image[sr][sc];
        image[sr][sc] = color;

        dfs(image, sr, sc, currentColor, color);

        return image;
    }
}
// @lc code=end
