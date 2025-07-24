class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        int[][] dist = new int[n][n];

        for(int[]row : dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0]=1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0,0});

        while(!q.isEmpty())
        {
            int[] curr = q.poll();

            int dis = curr[0];
            int row = curr[1];
            int col = curr[2];
            

            if(row == n-1 && col == n-1) return dis;

             for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {
                    if (dRow == 0 && dCol == 0) continue; // Skip the current cell

                    int newRow = row + dRow;
                    int newCol = col + dCol;

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 0 && dis + 1 < dist[newRow][newCol])
                        {

                        dist[newRow][newCol] = dis + 1;
                        q.offer(new int[]{dis + 1, newRow, newCol});
                    }
                }
            }
        }
        return -1;
    }
}