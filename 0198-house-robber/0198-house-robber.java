class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev_2 = 0;

        for(int i=0;i<nums.length;i++)
        {
            int pick = nums[i];

            if(i>1)
            {
                 pick+= prev_2;
            }

            int not_pick = prev;

            int curr = Math.max(pick,not_pick);
            prev_2 = prev;
            prev = curr;
        }
        return prev;
    }
}