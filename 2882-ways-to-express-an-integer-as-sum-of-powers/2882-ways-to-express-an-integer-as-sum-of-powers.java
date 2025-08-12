class Solution {
     public int mod = (int) 1e9 + 7;
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        int res = fn(n,x,n,dp);
        return res;
    }

    public int fn(int n,int x,int i,int[][]dp)
    {
        if(n==0) return 1;

        if(n<0 || i<=0) return 0;

        if(dp[n][i] != -1) return dp[n][i];

        int t = fn(n - (int) Math.pow(i, x), x, i - 1, dp);
        int s = fn(n, x, i - 1, dp);

        dp[n][i] = (t+s)%mod;
        return dp[n][i];
    }
}