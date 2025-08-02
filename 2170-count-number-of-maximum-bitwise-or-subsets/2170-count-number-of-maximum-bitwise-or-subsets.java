class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int n:nums)
        {
            maxOr |=n;
        }
        return dfs(nums,0,maxOr,0);
    }
    public int dfs(int[]nums,int currOr, int maxOr,int index)
    {
        if(index==nums.length) return currOr==maxOr ? 1:0;
        int take = dfs(nums,currOr|nums[index],maxOr,index+1);
        int not_take = dfs(nums,currOr,maxOr,index+1);

        return take + not_take;
    }
}