class Solution {
    
    int dp[];
    
    public int minPathSum(int[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;
        
        dp = new int[m];
        
        for(int i = 0; i < n; i++) {
            
            int cur[] = new int[m];
            
            for(int j = 0; j < m; j++) {
                
                if(i == 0 && j == 0) {
                    cur[0] = grid[0][0];
                    continue;
                }
                
                int curr = (int)1e9;
                if(i != 0) curr = Math.min(curr, dp[j]);
                if(j != 0) curr = Math.min(curr, cur[j - 1]);
                
                
                cur[j] = curr + grid[i][j];
                
            }
            
            dp = cur;
            
        }
        
        return dp[m - 1];
        
    }
}