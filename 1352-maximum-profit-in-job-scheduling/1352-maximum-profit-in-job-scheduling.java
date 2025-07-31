public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) index[i] = i;
        Arrays.sort(index, Comparator.comparingInt(i -> startTime[i]));

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int left = i + 1, right = n, j = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (startTime[index[mid]] >= endTime[index[i]]) {
                    j = mid;
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[i] = Math.max(dp[i + 1], profit[index[i]] + dp[j]);
        }

        return dp[0];
    }
}