class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        String lcs = getLCS(s1, s2);
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        for (char c : lcs.toCharArray()) {
            while (i < s1.length() && s1.charAt(i) != c) ans.append(s1.charAt(i++));
            while (j < s2.length() && s2.charAt(j) != c) ans.append(s2.charAt(j++));
            ans.append(c);
            i++; j++;
        }
        ans.append(s1.substring(i));
        ans.append(s2.substring(j));
        return ans.toString();
    }

    private String getLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = (s1.charAt(i-1) == s2.charAt(j-1)) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                lcs.append(s1.charAt(i-1));
                i--; j--;
            } else if (dp[i-1][j] >= dp[i][j-1]) i--;
            else j--;
        }
        return lcs.reverse().toString();
    }
}
