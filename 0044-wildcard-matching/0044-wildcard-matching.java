class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] memo = new Boolean[m + 1][n + 1]; // null = unset
        return dfs(s, p, 0, 0, memo);
    }

    private boolean dfs(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];

        int m = s.length();
        int n = p.length();

        if (j == n) { // pattern exhausted
            memo[i][j] = (i == m);
            return memo[i][j];
        }

        boolean match = (i < m) && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i));

        if (p.charAt(j) == '*') {
            memo[i][j] = dfs(s, p, i, j + 1, memo) || (i < m && dfs(s, p, i + 1, j, memo));
        } else {
            memo[i][j] = match && dfs(s, p, i + 1, j + 1, memo);
        }

        return memo[i][j];
    }
}
