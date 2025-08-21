class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int min_row = m;
        int min_col = n;

        for(int[]temp : ops)
        {
            min_row = Math.min(min_row,temp[0]);
            min_col = Math.min(min_col,temp[1]);
        }
        return min_row * min_col;
    }
}