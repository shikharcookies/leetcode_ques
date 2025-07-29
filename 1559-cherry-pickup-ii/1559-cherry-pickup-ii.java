class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        // Fill with -1 (uncomputed state)
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        // Start from row 0, robot1 at column 0, robot2 at column m - 1
        return memo(0, 0, m - 1, grid, dp);
    }

    private int memo(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int n = grid.length, m = grid[0].length;

        // Out of bounds
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e9;

        // Base case: last row
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        // Already computed
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        // Try all 9 movement combinations
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int newJ1 = j1 + d1;
                int newJ2 = j2 + d2;

                int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                value += memo(i + 1, newJ1, newJ2, grid, dp);

                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}
