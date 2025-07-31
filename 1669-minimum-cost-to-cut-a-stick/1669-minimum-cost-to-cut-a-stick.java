class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c+2];
        for(int i=0;i<c;i++)
        {
            newCuts[i+1]= cuts[i];
        }
        newCuts[0]=0;
        newCuts[c+1]=n;
        Arrays.sort(newCuts);


        int[][]dp = new int[c+2][c+2];

        for(int len=2;len<=c+1;len++)
        {
            for(int i=0;i+len<=c+1;i++)
            {
                int j = i+len;
                dp[i][j]= Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++)
                {
                    int cost = newCuts[j]-newCuts[i] + dp[i][k] + dp[k][j];
                    dp[i][j]= Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[0][c+1];
    }
}