class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }

    public int solve(int ind, int[]arr, int[]dp)
    {
        if(ind==0) return arr[0];
        if(ind<0) return 0;
        if(dp[ind]!= -1) return dp[ind];

        int pick = arr[ind] + solve(ind-2,arr,dp);
        int not_pick = 0 + solve(ind-1,arr,dp);

        return dp[ind]= Math.max(pick,not_pick);
    }
}