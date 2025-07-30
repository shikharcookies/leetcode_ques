class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount+1];

        for(int i=0;i<n;i++)
        {
            int[] curr = new int[amount+1];

            for(int k=1;k<=amount;k++)
            {
                int use = (int) 1e9, notUse = (int) 1e9;

                if(coins[i]<=k)
                {
                    use = 1 + curr[k-coins[i]];
                }
                if(i>0)
                {
                    notUse = prev[k];
                }

                curr[k]= Math.min(notUse,use);
            }
            prev = curr;
        }
        return prev[amount] >= (int) 1e9 ? -1 : prev[amount];
    }
}