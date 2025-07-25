class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxarea = 0; // To track the maximum area found so far
        int n = grid.length;
        int m = grid[0].length;

        // Traverse each cell in the grid
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // Start DFS if the current cell is land (1)
                if(grid[i][j] == 1) {
                    // Calculate area of this island using DFS
                    int area = dfs(grid, i, j);
                    // Update max area if current island is bigger
                    maxarea = Math.max(area, maxarea);
                }
            }
        }
        return maxarea;
    }

    // DFS to calculate the area of an island
    public int dfs(int[][] grid, int i, int j) {
        // Check for out-of-bounds or water or already visited
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        // Mark the current land cell as visited by converting to water (0)
        grid[i][j] = 0;

        int area = 1; // Current cell contributes 1 to the area

        // Explore in all 4 directions
        area += dfs(grid, i + 1, j); // Down
        area += dfs(grid, i - 1, j); // Up
        area += dfs(grid, i, j + 1); // Right
        area += dfs(grid, i, j - 1); // Left

        return area; // Return the total area of connected island
    }
}
