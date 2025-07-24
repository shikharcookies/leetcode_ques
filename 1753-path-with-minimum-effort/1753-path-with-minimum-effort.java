import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        if (n == 0 || m == 0) return 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Min-effort to reach each cell
        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        // PriorityQueue: [effortSoFar, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // Start at (0,0) with effort 0

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currEffort = current[0];
            int row = current[1];
            int col = current[2];

            // If reached destination
            if (row == n - 1 && col == m - 1) return currEffort;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int diff = Math.abs(heights[newRow][newCol] - heights[row][col]);
                    int newEffort = Math.max(currEffort, diff);

                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        pq.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }

        return -1; // In case unreachable (shouldn't happen for valid grid)
    }
}

// TC: O(R * C * log(R * C))
// SC: O(R * C)