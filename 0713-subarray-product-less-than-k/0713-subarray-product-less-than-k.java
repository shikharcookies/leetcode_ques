class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int count = 0, prdct = 1;
        while (i <= j && j < nums.length) {
            prdct *= nums[j];
            while (i <= j && prdct >= k) {
                prdct /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}