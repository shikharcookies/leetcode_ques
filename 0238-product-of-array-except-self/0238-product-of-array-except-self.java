class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int pre=1,suff=1;

        for(int i=0;i<n;i++)
        {
            res[i] = pre;
            pre= nums[i]*pre;
        }

        for(int i=nums.length-1;i>=0;i--)
        {
            res[i] = res[i]*suff;
            suff = nums[i]*suff;
        }

        return res;
    }
}