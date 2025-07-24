class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, 0, 0});
        int maxEffort = 0;

        int n = heights.length;
        int m = heights[0].length;
        if(n == 0) return 0;

        Set<String> visited = new HashSet<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int distVal = current[0];
            int row = current[1];
            int col = current[2];

            maxEffort = Math.max(distVal, maxEffort);
            if(row == n-1 && col == m-1) return maxEffort;
            visited.add(row + "," + col);

            for(int i = 0; i < 4; i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !visited.contains(nrow + "," + ncol)){
                    int newEffort = Math.abs(heights[nrow][ncol] - heights[row][col]);
                    pq.offer(new int[]{newEffort, nrow, ncol});
                }
            }
        }

        return maxEffort;
    }
}

// TC: O(R * C * log(R * C))
// SC: O(R * C)