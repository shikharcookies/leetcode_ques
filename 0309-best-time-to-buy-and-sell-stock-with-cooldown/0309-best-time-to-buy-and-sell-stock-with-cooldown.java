class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2];

        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return fn(0,1,n,prices,dp);
    }

    public int fn(int ind,int buy, int n, int[]prices,int[][]dp)
    {
        if (ind>=n) return 0;
        if (dp[ind][buy]!=-1) return dp[ind][buy];

        int profit=0;
        if(buy==1)
        {
            profit = Math.max(-prices[ind]+fn(ind+1,0,n,prices,dp), 0+fn(ind+1,1,n,prices,dp));
        }
        else {
            profit = Math.max(prices[ind]+fn(ind+2,1,n,prices,dp), 0+fn(ind+1,0,n,prices,dp));
        }
        return dp[ind][buy]= profit;
    }
}