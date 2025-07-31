class Solution {
    public int minDistance(String word1, String word2) {
          int n = word1.length();
          int m = word2.length();

        // Create a 2D array to store the minimum edit distances
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column with their respective indices
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
// If the characters match, no edit is needed so take the value from the diagonal.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
        // If the characters don't match, take the minimum of three possibilities:
        // 1. Replace the character in S1 with the character in S2 (diagonal).
         // 2. Delete the character in S1 (left).
        // 3. Insert the character from S2 into S1 (up).
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}