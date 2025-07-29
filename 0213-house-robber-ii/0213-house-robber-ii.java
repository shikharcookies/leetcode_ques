class Solution {
    // House Robber I (linear version)
    private int robLinear(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;

            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    // House Robber II (circular version)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Create two new arrays:
        int[] arr1 = Arrays.copyOfRange(nums, 1, n);     // Excludes first house
        int[] arr2 = Arrays.copyOfRange(nums, 0, n - 1); // Excludes last house

        return Math.max(robLinear(arr1), robLinear(arr2));
    }
}
