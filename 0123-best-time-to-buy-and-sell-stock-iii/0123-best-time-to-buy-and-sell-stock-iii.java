class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        // Initialize dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return fn(0, 1, 2, n, prices, dp);
    }

    public static int fn(int ind, int buy, int cap, int n, int[] prices, int[][][] dp) {
        if (ind == n || cap == 0) return 0;

        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 1) {
            // We can buy
            profit = Math.max(
                -prices[ind] + fn(ind + 1, 0, cap, n, prices, dp),
                0 + fn(ind + 1, 1, cap, n, prices, dp));
        } else {
            // We can sell
            profit = Math.max(
                prices[ind] + fn(ind + 1, 1, cap - 1, n, prices, dp),
                0 + fn(ind + 1, 0, cap, n, prices, dp));
        }

        return dp[ind][buy][cap] = profit; 
    }
}
