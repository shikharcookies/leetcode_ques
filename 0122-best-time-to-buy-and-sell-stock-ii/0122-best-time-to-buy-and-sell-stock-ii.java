class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] cur = new int[2];

        // Base case: at the end, profit is 0 for both buy/sell
        ahead[0] = ahead[1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 0) {
                    // Option to buy or skip
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                } else {
                    // Option to sell or skip
                    profit = Math.max(0 + ahead[1], prices[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Move current to ahead for next iteration
            ahead[0] = cur[0];
            ahead[1] = cur[1];
        }

        return cur[0];  // Maximum profit starting from index 0, in "buy allowed" state
    }
}
