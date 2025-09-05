class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            if(visited.contains(nums[i]))
            {
                return true;
            }
            visited.add(nums[i]);
        }
        return false;
    }
}