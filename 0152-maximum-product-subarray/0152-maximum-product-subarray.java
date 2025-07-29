class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i: nums)
        {
            result = Math.max(i,result);
        }

        int curr_max = 1 , curr_min=1;

        for(int n: nums)
        {
            int temp = curr_max*n;
            curr_max = Math.max(temp,Math.max(curr_min*n,n));
            curr_min = Math.min(temp,Math.min(curr_min*n,n));
            result = Math.max(curr_max,result);

        }
        return result;
    }
}