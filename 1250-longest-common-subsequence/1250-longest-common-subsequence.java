class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int [][]dp = new int[n][m];
         for (int[] row : dp) {
            Arrays.fill(row, -1);  // Initialize with -1
        }

        return fn(n-1,m-1,text1,text2,dp);
    }

    public int fn(int i,int j,String text1,String text2, int[][]dp)
    {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!= -1) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)) return dp[i][j]= 1 + fn(i-1,j-1,text1,text2,dp);

        return dp[i][j]= 0 + Math.max(fn(i,j-1,text1,text2,dp),fn(i-1,j,text1,text2,dp));
    }
}