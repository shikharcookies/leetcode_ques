class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] cache = new boolean[m + 1][n + 1]; // use wrapper Boolean
        return memo(cache, s, p, 0, 0);
    }
    
    private boolean memo(boolean[][] cache, String s, String p, int i, int j) {
        if (cache[i][j] != false) return cache[i][j];

        int m = s.length();
        int n = p.length();

        if (i >= m && j >= n) return true;
        if (j >= n) return false;

        boolean match = (i < m) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < n && p.charAt(j + 1) == '*') {
            cache[i][j] = memo(cache, s, p, i, j + 2) || (match && memo(cache, s, p, i + 1, j));
        } else {
            cache[i][j] = match && memo(cache, s, p, i + 1, j + 1);
        }
        return cache[i][j];
    }
}
