class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mpp = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int diff = target - nums[i];

            if(mpp.containsKey(diff))
            {
                return new int[]{mpp.get(diff),i};
            }
            mpp.put(nums[i],i);
        }
        return null;
    }
}