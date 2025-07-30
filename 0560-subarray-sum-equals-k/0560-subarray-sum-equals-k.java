class Solution {
    public int subarraySum(int[] nums, int k) {
        int c = 0;
        int n = nums.length;

        HashMap<Integer,Integer> pre_sum = new HashMap<>();
        pre_sum.put(0,1);

        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum +=nums[i];
            if(pre_sum.containsKey(sum-k))
            {
                c += pre_sum.get(sum-k);
            }
            pre_sum.put(sum,pre_sum.getOrDefault(sum,0)+1);
        }
        return c;
    }
}