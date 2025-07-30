class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        for(int t=0;t<=amount;t++)
        {
            if(t%coins[0]==0)
            {
                prev[t]=1;
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int t=0;t<=amount;t++)
            {
                int notPick = prev[t];
                int pick=0;
                if(coins[i]<=t)
                {
                    pick = curr[t-coins[i]];
                }
                curr[t]= pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}