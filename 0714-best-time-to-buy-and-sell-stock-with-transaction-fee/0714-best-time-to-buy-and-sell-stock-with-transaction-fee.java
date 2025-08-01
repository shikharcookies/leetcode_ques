class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        long[] ahead = new long[2];
        long[] cur = new long[2];

        // Initialize base conditions
        ahead[0] = ahead[1] = 0;
        long profit;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                } else { // We can sell the stock
                    profit = Math.max(0 + ahead[1], prices[ind] - fee + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Copy current state to ahead for next iteration
            ahead = cur.clone();
        }

        return (int) cur[0];
    }
}
