class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int major = 0;

        for(int i:nums)
        {
            if(major==0)
            {
                res = i;
            }

            major += i == res ? 1 : -1;
        }

        return res;

    }
}