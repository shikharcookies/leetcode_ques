class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        int result = Math.max(0, dfs(grid, 0, 0, 0, dp));
        return result;
    }

    private int dfs(int[][] grid, int r1, int c1, int r2, Integer[][][] dp) {
        int n = grid.length;
        int c2 = r1 + c1 - r2;

        // Out of bounds or on thorn
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // Reached end
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        if (dp[r1][c1][r2] != null)
            return dp[r1][c1][r2];

        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) // don't double-count if both people are at same cell
            cherries += grid[r2][c2];

        // Explore all 4 movement combinations
        int max = Math.max(Math.max(
                    dfs(grid, r1 + 1, c1, r2 + 1, dp),
                    dfs(grid, r1, c1 + 1, r2, dp)),
                Math.max(
                    dfs(grid, r1 + 1, c1, r2, dp),
                    dfs(grid, r1, c1 + 1, r2 + 1, dp)));

        cherries += max;

        return dp[r1][c1][r2] = cherries;
    }
}
