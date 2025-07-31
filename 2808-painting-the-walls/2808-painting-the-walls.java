class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, (int)1e9);  // Fill with a large number
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                int idx = Math.max(0, j - time[i] - 1);
                dp[j] = Math.min(dp[j], dp[idx] + cost[i]);
            }
        }

        return dp[n];
    }
}
